package com.cluster.data;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Fred on 2/28/17.
 */
public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findById(long id);
}
