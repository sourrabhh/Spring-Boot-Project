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

import com.restwebservice.restful_web_services.JPA.PostRepository;
import com.restwebservice.restful_web_services.JPA.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource 
{
    // private UserDaoService service;

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJpaResource( UserRepository userRepository, PostRepository postRepository)
    {
        // this.service = service;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    // GET/users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers()
    {
        return userRepository.findAll();
    }

    // HATEOAS 
    // EntityModel 
    // WebMvcLinkBuilder

    @GetMapping("/jpa/users/{id}")
    public EntityModel<Optional<User>> retrieveUser(@PathVariable int id)
    {
        Optional<User> userObj =  userRepository.findById(id);
        if(userObj.isEmpty()){
            throw new UserNotFoundException("ID :: " +id);
        }
        EntityModel<Optional<User>> entityModel = EntityModel.of(userObj);

        // WebMvcLinkBuilder for Links 
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }


    //  POST/users
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User userObj)
    {
        User savedUser = userRepository.save(userObj);
        // shows the location like 'users/4'
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    // Delete Users
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userRepository.deleteById(id);
    }

    // ---------- POST Repository ------------------//

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostForUser(@PathVariable int id)
    {
        Optional<User> userObj =  userRepository.findById(id);
        if(userObj.isEmpty()){
            throw new UserNotFoundException("ID :: " +id);
        }

        return userObj.get().getPostObj();
    }
     
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostsForUser(@PathVariable int id, @Valid @RequestBody Post postObj)
    {
        Optional<User> userObj =  userRepository.findById(id);
        if(userObj.isEmpty()){
            throw new UserNotFoundException("ID :: " +id);
        }

        postObj.setUserObj(userObj.get());
        Post savedPost = postRepository.save(postObj);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

      //*/
    
}
