package com.example.basicSpringPractice.service;

import com.example.basicSpringPractice.DTO.requestDTO.LoginRequestDTO;
import com.example.basicSpringPractice.DTO.requestDTO.RegistrationRequestDTO;
import com.example.basicSpringPractice.DTO.requestDTO.UpdateCustomerProfileRequestDTO;
import com.example.basicSpringPractice.DTO.responseDTO.CustomerResponseDTO;
import com.example.basicSpringPractice.entity.Customer;
import com.example.basicSpringPractice.exception.ResourceNotFoundException;
import com.example.basicSpringPractice.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder(10);

    public ResponseEntity<CustomerResponseDTO> getCustomer(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer Not Found"));
        return ResponseEntity.ok(modelMapper.map(customer, CustomerResponseDTO.class));
    }

    public ResponseEntity<?> updateProfile(int id, UpdateCustomerProfileRequestDTO dto) {
        Customer customer = customerRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customerRepository.save(customer);
        return ResponseEntity.ok().body(modelMapper.map(customer, CustomerResponseDTO.class));

    }

    public ResponseEntity<String> deleteCustomer(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        customerRepository.delete(customer);
        return ResponseEntity.ok().body("Successfully deleted customer");
    }

    public ResponseEntity<String> customerRegistration(RegistrationRequestDTO dto) {
        Optional<Customer> existingCustomer = customerRepository.findByEmail(dto.getEmail());

        if (existingCustomer.isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPassword(encoder.encode(dto.getPassword()));
        customer.setAge(dto.getAge());
        customer.setActive(true);
        customer.setVerify(false);
        customerRepository.save(customer);
        return ResponseEntity.ok().body("Successfully created customer");
    }

    public ResponseEntity<String> customerLogin(@Valid LoginRequestDTO dto) {
        Optional<Customer> customer = customerRepository.findByEmail(dto.getEmail());

        if (customer.isEmpty()) {
            log.error("Invalid email");
            throw new ResourceNotFoundException("Invalid email");
        }

        if (customer.get().getPassword().equals(dto.getPassword())) {
            log.error("Invalid password ");
            throw new ResourceNotFoundException("Invalid password");
        }
        return ResponseEntity.ok().body("Successfully logged in");
    }

    public ResponseEntity<List<CustomerResponseDTO>> getCustomerOrderByAge() {
        List<Customer> customer = customerRepository.findAllOrderByAgeAsc();
        List<CustomerResponseDTO> customerResponseDTOS = new ArrayList<>();
        for (Customer c : customer) {
            customerResponseDTOS.add(modelMapper.map(c, CustomerResponseDTO.class));
        }
        return ResponseEntity.ok(customerResponseDTOS);
    }

    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS = new ArrayList<>();
        for (Customer c : customers) {
            customerResponseDTOS.add(modelMapper.map(c, CustomerResponseDTO.class));
        }
        return ResponseEntity.ok(customerResponseDTOS);
    }

    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomersWithAge(int age) {
        List<Customer> customers = customerRepository.getAllCustomersWithAge(age);
        List<CustomerResponseDTO> customerResponseDTOS = new ArrayList<>();
        for (Customer c : customers) {
            customerResponseDTOS.add(modelMapper.map(c, CustomerResponseDTO.class));
        }
        return ResponseEntity.ok(customerResponseDTOS);
    }
}
