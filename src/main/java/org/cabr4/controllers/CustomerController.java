// Package where this controller class is located
package org.cabr4.controllers;

// Import the Customer entity (data model)
import org.cabr4.model.Customer;

// Import the service implementation that contains business logic
import org.cabr4.services.CustomerServiceImpl;

// Spring annotations for building REST APIs
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
  private final CustomerServiceImpl customerService;

  // Constructor-based dependency injection
  // Spring injects CustomerServiceImpl automatically
  public CustomerController(CustomerServiceImpl customersService) {
    this.customerService = customersService;
  }

  // Handles HTTP GET requests to /customers
  // Returns a list of all customers
  @GetMapping
  public List<Customer> getCustomers() {
    return customerService.getAllCustomers();
  }

  // Handles HTTP POST requests to /customers
  // @RequestBody maps the incoming JSON to a Customer object
  // Used to create a new customer
  @PostMapping
  public Customer save(@RequestBody Customer customer) {
    return customerService.createCustomer(customer);
  }

  // Handles HTTP PUT requests to /customers
  // Used to update an existing customer
  // NOTE: method name has a typo -> "upadte"
  @PutMapping
  public Customer upadte(@RequestBody Customer customer) {
    return customerService.updateCustomer(customer);
  }
}
