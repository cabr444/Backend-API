package org.cabr4.services;

// Imports the User entity used by the service layer
import org.cabr4.model.User;

// Import for handling collections of User objects
import java.util.List;

/**
 * Service interface for managing User-related business operations.
 *
 * This interface defines the contract for the service layer, which
 * contains the business logic related to User entities.
 * Implementations of this interface should coordinate validation,
 * business rules, and interaction with the persistence layer.
 */
public interface CustomerService {

  /**
   * Retrieves all customers from the system.
   *
   * @return a list containing all persisted customers
   */
  List<User> getAllCustomers();

  /**
   * Creates and persists a new user.
   *
   * This method may include business validations such as checking
   * required fields or enforcing unique constraints.
   *
   * @param user the user entity to be created
   * @return the persisted user entity
   */
  User createCustomer(User user);

  User findById (Long id);

  /**
   * Updates an existing user.
   *
   * Implementations should ensure that the user exists
   * before performing the update and apply any relevant
   * business rules.
   *
   * @param user the user entity with updated information
   * @return the updated user entity
   */
  User updateCustomer(Long id, User user);

  /**
   * Deletes a customer by its unique identifier.
   *
   * Implementations should verify the existence of the customer
   * and handle any business constraints before deletion.
   *
   * @param id the unique identifier of the customer to be deleted
   */
  void deleteCustomer(Long id);
}
