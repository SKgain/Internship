package com.example.basicSpringPractice.repository;

import com.example.basicSpringPractice.entity.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(@NotBlank(message = "Must be provide your registered email") @Email(message = "Must be provide your registered email") String email);

    @Query("SELECT c FROM Customer c ORDER BY c.age ASC")
    List<Customer> findAllOrderByAgeAsc();
    @Query(value="SELECT * FROM Customer WHERE age>:age ORDER BY age ASC", nativeQuery=true)
    List<Customer> getAllCustomersWithAge(int age);

}
