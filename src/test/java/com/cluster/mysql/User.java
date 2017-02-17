package com.cluster.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by shane on 2/16/17.
 *
 * Example on how Database can be used in Spring
 *
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    private String name;
    private String email;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
