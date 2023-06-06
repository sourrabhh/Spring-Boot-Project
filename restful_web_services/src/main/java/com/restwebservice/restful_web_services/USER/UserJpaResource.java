package com.restwebservice.restful_web_services.USER;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.restwebservice.restful_web_services.JPA.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource 
{
    // private UserDaoService service;

    private UserRepository repository;

    public UserJpaResource( UserRepository repository)
    {
        // this.service = service;
        this.repository = repository;
    }

    // GET/users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers()
    {
        return repository.findAll();
    }

    // HATEOAS 
    // EntityModel 
    // WebMvcLinkBuilder

    @GetMapping("/jpa/users/{id}")
    public EntityModel<Optional<User>> retrieveUser(@PathVariable int id)
    {
        Optional<User> userObj =  repository.findById(id);
        if(userObj.isEmpty()){
            throw new UserNotFoundException("ID :: " +id);
        }
        EntityModel<Optional<User>> entityModel = EntityModel.of(userObj);

        // WebMvcLinkBuilder for Links 
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }


    //  POSR/users
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User userObj)
    {
        User savedUser = repository.save(userObj);
        // shows the location like 'users/4'
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    // Delete Users
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        repository.deleteById(id);
    }
}
