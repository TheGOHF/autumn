package ru.bgpu.autumn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.bgpu.autumn.models.User;
import ru.bgpu.autumn.services.UserService;

@Component
@Profile("dev")
public class DevInitConfig implements CommandLineRunner {

    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {
        for(int i = 0; i < 10; i++) {
            userService.save(new User("login-"+i,"test-"+i));
        }
    }
}
