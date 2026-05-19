package ru.bgpu.autumn.services;

import org.springframework.stereotype.Service;
import ru.bgpu.autumn.models.User;
import ru.bgpu.autumn.models.Group;
import ru.bgpu.autumn.repositories.UserRepository;

import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean isMemberOfGroup(User user, String groupName) {
        if (user == null || user.getGroups() == null || groupName == null) return false;
        return user.getGroups().stream().anyMatch(g -> g.getName().equals(groupName));
    }

    public Set<Group> getUserGroups(User user) {
        return user != null ? user.getGroups() : Set.of();
    }
}