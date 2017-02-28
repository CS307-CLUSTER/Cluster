package com.cluster.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Fred on 2/28/17.
 */

@Entity
public class UserCluster {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer user_id;
    private Integer cluster_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCluster_id() {
        return cluster_id;
    }

    public void setCluster_id(Integer cluster_id) {
        this.cluster_id = cluster_id;
    }
}
