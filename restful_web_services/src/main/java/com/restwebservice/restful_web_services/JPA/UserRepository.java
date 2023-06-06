package com.restwebservice.restful_web_services.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restwebservice.restful_web_services.USER.User;



public interface UserRepository extends JpaRepository<User,Integer>
{
    
}
