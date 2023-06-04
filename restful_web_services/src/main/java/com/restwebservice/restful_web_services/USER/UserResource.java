package com.restwebservice.restful_web_services.USER;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource 
{
    private UserDaoService service;

    public UserResource(UserDaoService service)
    {
        this.service = service;
    }

    // GET/users
    @GetMapping("/users")
    public List<User> retrieveAllUsers()
    {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id)
    {
        User userObj =  service.findOne(id);
        if(userObj == null){
            throw new UserNotFoundException("ID :: " +id);
        }
        return userObj;
    }

    //  POSR/users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User userObj)
    {
        User savedUser = service.saveUser(userObj);
        // shows the location like 'users/4'
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    // Delete Users
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        service.deleteById(id);
    }
}
