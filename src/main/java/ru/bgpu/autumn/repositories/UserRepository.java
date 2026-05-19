package ru.bgpu.autumn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bgpu.autumn.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}