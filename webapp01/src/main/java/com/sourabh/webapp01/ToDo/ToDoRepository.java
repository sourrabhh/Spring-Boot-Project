package com.sourabh.webapp01.ToDo;

import java.util.List;
// import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ToDoRepository extends JpaRepository<ToDo,Integer> 
{
    public List<ToDo> findByUserName(String userName);  
}
