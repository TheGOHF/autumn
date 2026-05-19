package ru.bgpu.autumn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bgpu.autumn.models.VoteAnswer;

public interface VoteAnswerRepository extends JpaRepository<VoteAnswer, Long> {
}