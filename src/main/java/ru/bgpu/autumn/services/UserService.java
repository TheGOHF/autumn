package ru.bgpu.autumn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bgpu.autumn.models.User;
import ru.bgpu.autumn.repositories.UserRepository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> listUsers() {
        List<User> list = new ArrayList<>();
        for(User user: userRepository.findAll()) {
            list.add(user);
        }
        return list;
    }
}
