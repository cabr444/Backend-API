// Package where this controller class is located
package org.cabr4.controllers;

// Import the Customer entity (data model)
import jakarta.validation.Valid;
import org.cabr4.model.Customer;

// Import the service implementation that contains business logic
import org.cabr4.services.CustomerService;

// Spring annotations for building REST APIs
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Utility for handling lists of objects
import java.util.List;

// Marks this class as a REST controller
// Spring will automatically expose its methods as HTTP endpoints
@RestController

// Base URL for all endpoints in this controller
// Example: /customers
@RequestMapping("/customers")
public class CustomerController {

  // Service layer dependency
  // 'final' ensures it is initialized only once (best practice)
  private final CustomerService customerService;

  // Constructor-based dependency injection
  // Spring injects CustomerServiceImpl automatically
  public CustomerController(CustomerService customersService) {
    this.customerService = customersService;
  }

  // Handles HTTP GET requests to /customers
  // Returns a list of all customers
  @GetMapping
  public ResponseEntity<List<Customer>> getCustomers() {
    return ResponseEntity.ok(customerService.getAllCustomers());
  }

  // Handles HTTP POST requests to /customers
  // @RequestBody maps the incoming JSON to a Customer object
  // Used to create a new customer;
  @PostMapping
  public ResponseEntity<Customer> create(@Valid @RequestBody Customer customer) {

    Customer customerSaved = customerService.createCustomer(customer);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(customerSaved);
  }

  // Handles HTTP PUT requests to /customers
  // Used to update an existing customer
  // NOTE: method name has a typo -> "upadte"
  @PutMapping("/{id}")
  public ResponseEntity<Customer> upadte(@PathVariable Long id, @Valid @RequestBody Customer customer) {

    Customer updateCustomer = customerService.updateCustomer(id, customer);

    return ResponseEntity.ok(updateCustomer);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete_(@PathVariable Long id){

    customerService.deleteCustomer(id);

    return ResponseEntity.noContent().build();
  }
}
