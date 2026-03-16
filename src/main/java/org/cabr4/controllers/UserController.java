// Package where this controller class is located
package org.cabr4.controllers;

// Import the User entity (data model)
import jakarta.validation.Valid;
import org.cabr4.model.User;

// Import the service implementation that contains business logic
import org.cabr4.services.UserService;

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
@RequestMapping("/users")
public class UserController {

  // Service layer dependency
  // 'final' ensures it is initialized only once (best practice)
  private final UserService userService;

  // Constructor-based dependency injection
  // Spring injects UserServiceImpl automatically
  public UserController(UserService usersService) {
    this.userService = usersService;
  }

  // Handles HTTP GET requests to /customers
  // Returns a list of all customers
  @GetMapping
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity <User> findUserById(@PathVariable Long id) {
    User findUser = userService.findUserById(id);
    return ResponseEntity.ok(findUser);
  }

  // Handles HTTP POST requests to /customers
  // @RequestBody maps the incoming JSON to a User object
  // Used to create a new user;
  @PostMapping
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

    User userSaved = userService.createUser(user);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(userSaved);
  }

  // Handles HTTP PUT requests to /customers
  // Used to update an existing user
  // NOTE: method name has a typo -> "upadte"
  @PutMapping("/{id}")
  public ResponseEntity<User> updateCustomer(@PathVariable Long id, @Valid @RequestBody User user) {

    User updateUser = userService.updateUser(id, user);

    return ResponseEntity.ok(updateUser);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){

    userService.deleteUserById(id);

    return ResponseEntity.noContent().build();
  }
}
