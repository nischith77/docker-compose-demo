package com.gozde.dockercomposedemo.controller;

import com.gozde.dockercomposedemo.model.Customer;
import com.gozde.dockercomposedemo.model.dto.CreateCustomerDto;
import com.gozde.dockercomposedemo.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return ResponseEntity.ok(allCustomers);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCustomerDto> createCustomer(@RequestBody CreateCustomerDto dto) {
        customerService.createCustomer(dto);
        return ResponseEntity.ok(dto);
    }
}
