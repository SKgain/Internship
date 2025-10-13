package com.example.bank.service;

import com.example.bank.DTO.requestDTO.SignInRequestDTO;
import com.example.bank.DTO.requestDTO.SignUpRequestDTO;
import com.example.bank.constant.AppConstant;
import com.example.bank.entity.Account;
import com.example.bank.entity.User;
import com.example.bank.exception.DuplicateResourceException;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final PasswordEncoder encoder;


    public ResponseEntity<?> signUp(@Valid SignUpRequestDTO signUpRequestDTO) {
        Optional<User> existUser = userRepository.findByEmail(signUpRequestDTO.getEmail().toLowerCase());

        if (existUser.isPresent()) {
            throw new DuplicateResourceException(AppConstant.USER_ALREADY_EXISTS + signUpRequestDTO.getEmail());
        }
        User user = new User();
        user.setEmail(signUpRequestDTO.getEmail().toLowerCase());
        user.setFullName(signUpRequestDTO.getFullName());
        user.setPassword(encoder.encode(signUpRequestDTO.getPassword()));
        user.setRole(AppConstant.INITIAL_USER_ROLE);

        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
        account.setUser(user);

        user.setAccount(account);

        userRepository.save(user);

        log.info("User signed up with email : {}", user.getEmail());
        return ResponseEntity.ok().body(user);
    }

    private String generateAccountNumber() {
        Optional<Account> lastAccount = accountRepository.findTopByOrderByIdDesc();

        if (lastAccount.isPresent()) {
            String lastAccNo = lastAccount.get().getAccountNumber();
            if (lastAccNo == null || !lastAccNo.startsWith(AppConstant.INITIAL_ACCOUNT_CODE)) {
                return AppConstant.INITIAL_ACCOUNT_NUMBER;
            }
            int lastNum = Integer.parseInt(lastAccNo.substring(3));
            return AppConstant.INITIAL_ACCOUNT_CODE + (lastNum + 1);
        } else {
            return AppConstant.INITIAL_ACCOUNT_NUMBER;
        }
    }


    public ResponseEntity<?> signIn(@Valid SignInRequestDTO signInRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signInRequestDTO.getEmail().toLowerCase(),
                            signInRequestDTO.getPassword()
                    )
            );

            if (authentication.isAuthenticated()) {
                String token = jwtService.generateToken(signInRequestDTO.getEmail());
                return ResponseEntity.ok(Map.of("accessToken", token));
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", AppConstant.INCORRECT_PASSWORD_OR_EMAIL));

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", AppConstant.INCORRECT_PASSWORD_OR_EMAIL));
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", AppConstant.EMAIL_NOT_FOUND));
        }
    }

}
