package org.example.springbootproject.service;

import org.example.springbootproject.exception.NoEntityException;
import org.example.springbootproject.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User save(User user);

    User getById(Long id) throws NoEntityException;

    void deleteById(Long id);

}
