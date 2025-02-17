package com.example.users.service;

import com.example.users.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList;

    public UserService() {
        userList = new ArrayList<User>();

    }

    public Optional<User> getUserById(Integer Id){
        Optional<User> optional = Optional.empty();

        for (User user : userList) {
            if(user.getId() == Id){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }

    public Optional<User> createUser(User user){
      Optional<User> optional = Optional.empty();
      optional= Optional.of(new User(user.getId(), user.getName(), user.getIdade(), user.getEmail()));
      userList.add(optional.get());
      return optional;
    };


    public List<User> getAllUsers() {
        return userList;
    };


    public boolean removeUserById(Integer id) {
        Optional<User> userToRemove = getUserById(id);

        if (userToRemove.isPresent()) {
            userList.remove(userToRemove.get());
            return true;
        }

        return false;
    }
};
