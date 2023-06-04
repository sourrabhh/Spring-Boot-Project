package com.restwebservice.restful_web_services.USER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService 
{
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static{
        users.add(new User(++usersCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount,"Jimmy", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll()
    {
        return users;
    }

    public User findOne(int id)
    {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    // Create User 
    public User saveUser(User userObj)
    {
        userObj.setId(++usersCount);
        users.add(userObj);
        return userObj;
    }

    public void deleteById(int id)
    {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}