package ru.bgpu.autumn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bgpu.autumn.models.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}