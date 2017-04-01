package com.cluster.data;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Fred on 3/2/17.
 */
public interface ClustersRepository extends CrudRepository<Clusters, Long> {

    Clusters findById(long id);

}
