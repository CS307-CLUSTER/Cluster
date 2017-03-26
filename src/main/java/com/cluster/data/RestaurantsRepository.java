package com.cluster.data;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Fred on 3/25/17.
 */
public interface RestaurantsRepository extends CrudRepository<Restaurants, Long> {

    Restaurants findById(long id);
}
