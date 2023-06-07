package com.restwebservice.restful_web_services.USER;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "userDetails")
public class User 
{
    protected User()
    {    }
    
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Name must be two character")
    // @JsonProperty("User_Name")
    private String name;

        // @JsonProperty("Birth_Date")
    @Past(message = "Birth Date must be in past")
    private LocalDate birthDate;
    
    // single User have many post so onetomany
    @OneToMany(mappedBy = "userObj")
    @JsonIgnore
    private List<Post> postObj;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPostObj() {
        return postObj;
    }

    public void setPostObj(List<Post> postObj) {
        this.postObj = postObj;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", postObj=" + postObj + "]";
    }



    // @Override
    // public String toString() {
    //     return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    // }

    // ----------------- 
  
}
