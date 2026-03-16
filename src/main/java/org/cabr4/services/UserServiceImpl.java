package org.cabr4.services;

import org.cabr4.exceptions.ResourceNotFoundException;
import org.cabr4.model.User;
import org.cabr4.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service implementation for managing User-related operations.
 *
 * This class contains the business logic for User entities and
 * acts as a bridge between the controller layer and the data access
 * layer (UserRepository).
 */
@Service
public class UserServiceImpl implements UserService {

  /**
   * Repository used to perform CRUD operations on User entities.
   * Declared as final to ensure immutability and promote best practices.
   */
  private final UserRepository userRepository;

  /**
   * Constructor-based dependency injection.
   *
   * Spring automatically injects an instance of UserRepository
   * when creating this service bean.
   *
   * @param userRepository the repository used for User persistence
   */
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Retrieves all customers from the database.
   *
   * @return a list containing all persisted User entities
   */
  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
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
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User findUserById(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id" +id+ "not found"));
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
  public User updateUser(Long id, User user) {

    //ADD ALL PARAMS !!!!!!!!!!!!!!

    User userExist = userRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("User not found !"));
    userExist.setName(user.getName());
    userExist.setLastName(user.getLastName());
    userExist.setAge(user.getAge());
    userExist.setPhone(user.getPhone());
    userExist.setEmail(user.getEmail());
    userExist.setPassword(user.getPassword());

    return userRepository.save(userExist);
  }

  /**
   * Deletes a customer by its unique identifier.
   * enforce business constraints prior to deletion.
   * @param id the unique identifier of the User to be deleted
   */
  @Override
  public void deleteUserById(Long id) {
    userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    userRepository.deleteById(id);
  }
}
