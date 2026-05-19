package ru.bgpu.autumn.services;

import org.springframework.stereotype.Service;
import ru.bgpu.autumn.models.VoteAnswer;
import ru.bgpu.autumn.repositories.VoteAnswerRepository;

@Service
public class VoteAnswerService {
    private final VoteAnswerRepository voteAnswerRepository;

    public VoteAnswerService(VoteAnswerRepository voteAnswerRepository) {
        this.voteAnswerRepository = voteAnswerRepository;
    }

    public VoteAnswer save(VoteAnswer voteAnswer) {
        return voteAnswerRepository.save(voteAnswer);
    }
}