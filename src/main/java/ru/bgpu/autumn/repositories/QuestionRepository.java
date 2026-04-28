package ru.bgpu.autumn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bgpu.autumn.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}