package org.cabr4.controllers;

import jakarta.validation.Valid;
import org.cabr4.model.Customer;
import org.cabr4.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  // Service layer dependency
  // 'final' ensures it is initialized only once (best practice)
  private final CustomerService customerService;

  // Constructor-based dependency injection
  // Spring injects UserServiceImpl automatically
  public CustomerController(CustomerService customersService) {
    this.customerService = customersService;
  }

  // Handles HTTP GET requests to /customers
  // Returns a list of all customers
  @GetMapping
  public ResponseEntity<List<Customer>> getCustomers() {
    return ResponseEntity.ok(customerService.getAllCustomers());
  }

  @GetMapping("/{id}")
  public ResponseEntity <Customer> findCustomerById(@PathVariable Long id) {
    Customer findCustomer = customerService.findById(id);
    return ResponseEntity.ok(findCustomer);
  }

  // Handles HTTP POST requests to /customers
  // @RequestBody maps the incoming JSON to a User object
  // Used to create a new user;
  @PostMapping
  public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {

    Customer customerSaved = customerService.createCustomer(customer);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(customerSaved);
  }

  // Handles HTTP PUT requests to /customers
  // Used to update an existing user
  // NOTE: method name has a typo -> "upadte"
  @PutMapping("/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {

    Customer updateCustomer = customerService.updateCustomer(id, customer);

    return ResponseEntity.ok(updateCustomer);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){

    customerService.deleteCustomer(id);

    return ResponseEntity.noContent().build();
  }
}
