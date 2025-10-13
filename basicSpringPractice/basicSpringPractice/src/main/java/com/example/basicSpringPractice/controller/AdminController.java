package com.example.basicSpringPractice.controller;

import com.example.basicSpringPractice.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@AllArgsConstructor
public class AdminController {
    private CustomerService customerService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("admin/update-user-role/{id}")
    public ResponseEntity<String> updateUserRole(@RequestBody Set<String> role,@PathVariable int id){
        log.info("Customer Update User Role");
        return ResponseEntity.ok().body(customerService.updateUserRole(role,id));
    }
}
