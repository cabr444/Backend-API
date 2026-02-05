package org.cabr4.repository;

// Imports the Customer entity that will be managed by this repository
import org.cabr4.model.Customer;

// Provides built-in CRUD, pagination, and sorting operations
import org.springframework.data.jpa.repository.JpaRepository;

// Indicates that this interface is a Spring Data repository component
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Customer entity.
 *
 * This interface extends JpaRepository, enabling standard
 * CRUD (Create, Read, Update, Delete) operations and
 * pagination support without requiring explicit implementation.
 *
 * <Customer, Long> specifies:
 * - Customer as the managed entity type
 * - Long as the type of the entity's primary key
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  // Custom query methods can be declared here if needed,
  // for example: findByEmail(String email)
}
