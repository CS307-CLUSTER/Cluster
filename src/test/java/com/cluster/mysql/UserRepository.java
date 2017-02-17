package com.cluster.mysql;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shane on 2/16/17.
 *
 * Example on how Database can be used in Spring
 *
 */

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {

}