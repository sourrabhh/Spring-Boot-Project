package com.restwebservice.restful_web_services.USER;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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

    // HATEOAS 
    // EntityModel 
    // WebMvcLinkBuilder

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id)
    {
        User userObj =  service.findOne(id);
        if(userObj == null){
            throw new UserNotFoundException("ID :: " +id);
        }
        EntityModel<User> entityModel = EntityModel.of(userObj);

        // WebMvcLinkBuilder for Links 
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }


    //  POSR/users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User userObj)
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
