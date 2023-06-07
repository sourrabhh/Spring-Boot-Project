package com.restwebservice.restful_web_services.USER;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Post 
{
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 5)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)          // Coz userObj have many post
    @JsonIgnore
    private User userObj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", description=" + description + "]";
    }
    // --------------- Getters and Setters For US

    public User getUserObj() {
        return userObj;
    }

    public void setUserObj(User userObj) {
        this.userObj = userObj;
    }

}
