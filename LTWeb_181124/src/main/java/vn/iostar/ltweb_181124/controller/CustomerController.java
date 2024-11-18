package vn.iostar.ltweb_181124.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vn.iostar.ltweb_181124.model.Customer;

import java.util.List;

@RestController
@EnableMethodSecurity
public class CustomerController {

    final private List<Customer> customers = List.of(
            Customer.builder().id("001").name("Tran Trieu Vi").email("22110459@student.hmcute.edu.vn").build(),
            Customer.builder().id("002").name("Vix").email("hellno83737@gmail.com").build()
    );

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, guest!");
    }

    @GetMapping("/customer/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Customer>> getCustomerList() {
        List<Customer> customers = this.customers;

        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Customer> getCustomerList(@PathVariable("id") String id) {
        List<Customer> customers = this.customers.stream().filter(
                customer -> customer.getId().equals(id)
        ).toList();

        return ResponseEntity.ok(customers.get(0));
    }
}
