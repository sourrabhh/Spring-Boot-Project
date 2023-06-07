package com.restwebservice.restful_web_services.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restwebservice.restful_web_services.USER.Post;


public interface PostRepository extends JpaRepository<Post,Integer>
{
    
}
