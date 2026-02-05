package org.cabr4.services;

// Import of the Customer entity handled by this service
import org.cabr4.model.Customer;

// Repository responsible for persistence operations on Customer entities
import org.cabr4.repository.CustomerRepository;

// Marks this class as a Spring service component
import org.springframework.stereotype.Service;

// Import for handling collections of Customer entities
import java.util.List;

/**
 * Service implementation for managing Customer-related operations.
 *
 * This class contains the business logic for Customer entities and
 * acts as a bridge between the controller layer and the data access
 * layer (CustomerRepository).
 */
@Service
public class CustomerServiceImpl implements CustomerService {

  /**
   * Repository used to perform CRUD operations on Customer entities.
   * Declared as final to ensure immutability and promote best practices.
   */
  private final CustomerRepository customerRepository;

  /**
   * Constructor-based dependency injection.
   *
   * Spring automatically injects an instance of CustomerRepository
   * when creating this service bean.
   *
   * @param customerRepository the repository used for Customer persistence
   */
  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  /**
   * Retrieves all customers from the database.
   *
   * @return a list containing all persisted Customer entities
   */
  @Override
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  /**
   * Creates and persists a new customer.
   *
   * This method may include business validations before saving
   * the entity to the database.
   *
   * @param customer the Customer entity to be created
   * @return the persisted Customer entity
   */
  @Override
  public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  /**
   * Updates an existing customer.
   *
   * Implementations may verify the existence of the customer
   * and apply additional business rules before persisting changes.
   *
   * @param customer the Customer entity containing updated data
   * @return the updated Customer entity
   */
  @Override
  public Customer updateCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  /**
   * Deletes a customer by its unique identifier.
   *
   * Implementations may validate the existence of the customer
   * or enforce business constraints prior to deletion.
   *
   * @param id the unique identifier of the Customer to be deleted
   */
  @Override
  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }
}
