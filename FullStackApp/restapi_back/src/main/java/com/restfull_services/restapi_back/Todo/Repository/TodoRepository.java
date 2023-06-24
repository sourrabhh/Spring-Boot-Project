package com.restfull_services.restapi_back.Todo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfull_services.restapi_back.Todo.Todo;


public interface TodoRepository extends JpaRepository <Todo, Integer> 
{
    List<Todo> findByUsername(String username);
}
