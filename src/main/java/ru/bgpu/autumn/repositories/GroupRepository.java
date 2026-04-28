package ru.bgpu.autumn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bgpu.autumn.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}