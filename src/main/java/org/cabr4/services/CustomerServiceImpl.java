package org.cabr4.services;

// Import of the User entity handled by this service
import org.cabr4.exceptions.ResourceNotFoundException;
import org.cabr4.model.User;

// Repository responsible for persistence operations on User entities
import org.cabr4.repository.CustomerRepository;

// Marks this class as a Spring service component
import org.springframework.stereotype.Service;

// Import for handling collections of User entities
import java.util.List;

/**
 * Service implementation for managing User-related operations.
 *
 * This class contains the business logic for User entities and
 * acts as a bridge between the controller layer and the data access
 * layer (CustomerRepository).
 */
@Service
public class CustomerServiceImpl implements CustomerService {

  /**
   * Repository used to perform CRUD operations on User entities.
   * Declared as final to ensure immutability and promote best practices.
   */
  private final CustomerRepository customerRepository;

  /**
   * Constructor-based dependency injection.
   *
   * Spring automatically injects an instance of CustomerRepository
   * when creating this service bean.
   *
   * @param customerRepository the repository used for User persistence
   */
  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  /**
   * Retrieves all customers from the database.
   *
   * @return a list containing all persisted User entities
   */
  @Override
  public List<User> getAllCustomers() {
    return customerRepository.findAll();
  }

  /**
   * Creates and persists a new user.
   *
   * This method may include business validations before saving
   * the entity to the database.
   *
   * @param user the User entity to be created
   * @return the persisted User entity
   */
  @Override
  public User createCustomer(User user) {
    return customerRepository.save(user);
  }

  @Override
  public User findById(Long id) {
    return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id" +id+ "not found"));
  }

  /**
   * Updates an existing user.
   *
   * Implementations may verify the existence of the user
   * and apply additional business rules before persisting changes.
   *
   * @param user the User entity containing updated data
   * @return the updated User entity
   */
  @Override
  public User updateCustomer(Long id, User user) {

    //ADD ALL PARAMS !!!!!!!!!!!!!!

    User userExist = customerRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("User not found !"));
    userExist.setName(user.getName());
    userExist.setLastName(user.getLastName());
    userExist.setAge(user.getAge());
    userExist.setPhone(user.getPhone());
    userExist.setEmail(user.getEmail());
    userExist.setPassword(user.getPassword());

    return customerRepository.save(userExist);
  }

  /**
   * Deletes a customer by its unique identifier.
   *
   * Implementations may validate the existence of the customer
   * or enforce business constraints prior to deletion.
   *
   * @param id the unique identifier of the User to be deleted
   */
  @Override
  public void deleteCustomer(Long id) {
    customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    customerRepository.deleteById(id);
  }
}
