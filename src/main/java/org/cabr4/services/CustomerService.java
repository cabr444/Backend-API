package org.cabr4.services;

// Imports the Customer entity used by the service layer
import org.cabr4.model.Customer;

// Import for handling collections of Customer objects
import java.util.List;

/**
 * Service interface for managing Customer-related business operations.
 *
 * This interface defines the contract for the service layer, which
 * contains the business logic related to Customer entities.
 * Implementations of this interface should coordinate validation,
 * business rules, and interaction with the persistence layer.
 */
public interface CustomerService {

  /**
   * Retrieves all customers from the system.
   *
   * @return a list containing all persisted customers
   */
  List<Customer> getAllCustomers();

  /**
   * Creates and persists a new customer.
   *
   * This method may include business validations such as checking
   * required fields or enforcing unique constraints.
   *
   * @param customer the customer entity to be created
   * @return the persisted customer entity
   */
  Customer createCustomer(Customer customer);

  Customer findById (Long id);

  /**
   * Updates an existing customer.
   *
   * Implementations should ensure that the customer exists
   * before performing the update and apply any relevant
   * business rules.
   *
   * @param customer the customer entity with updated information
   * @return the updated customer entity
   */
  Customer updateCustomer(Long id, Customer customer);

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
