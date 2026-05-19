package ru.bgpu.autumn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bgpu.autumn.models.AnswerOption;

public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Long> {
}