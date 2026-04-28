package ru.bgpu.autumn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bgpu.autumn.models.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}