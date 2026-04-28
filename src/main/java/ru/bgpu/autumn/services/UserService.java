package ru.bgpu.autumn.services;

import org.springframework.stereotype.Service;
import ru.bgpu.autumn.models.User;
import ru.bgpu.autumn.models.Group;

import java.util.Set;

@Service
public class UserService {

    public boolean isMemberOfGroup(User user, String groupName) {
        if (user == null || user.getGroups() == null || groupName == null) {
            return false;
        }

        return user.getGroups().stream()
                .map(Group::getName)
                .anyMatch(name -> name.equalsIgnoreCase(groupName));
    }

    public boolean isAdmin(User user) {
        return isMemberOfGroup(user, "ADMIN");
    }

    public boolean isUser(User user) {
        return isMemberOfGroup(user, "USER");
    }
}