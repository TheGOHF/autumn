package ru.bgpu.autumn.services;

import org.springframework.stereotype.Service;
import ru.bgpu.autumn.models.AnswerOption;
import ru.bgpu.autumn.repositories.AnswerOptionRepository;

@Service
public class AnswerOptionService {
    private final AnswerOptionRepository answerOptionRepository;

    public AnswerOptionService(AnswerOptionRepository answerOptionRepository) {
        this.answerOptionRepository = answerOptionRepository;
    }

    public AnswerOption save(AnswerOption answerOption) {
        return answerOptionRepository.save(answerOption);
    }
}