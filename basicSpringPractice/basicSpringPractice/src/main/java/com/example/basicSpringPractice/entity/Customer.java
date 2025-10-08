package com.example.basicSpringPractice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;
    private  int age;
    private String password;
    private boolean active;
    private boolean verify;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    @JsonManagedReference("customer-order")
    private List<Order> orders;
}
