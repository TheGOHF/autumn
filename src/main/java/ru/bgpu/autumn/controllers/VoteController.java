package ru.bgpu.autumn.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bgpu.autumn.models.Vote;
import ru.bgpu.autumn.repositories.VoteRepository;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {
    private final VoteRepository voteRepository;

    public VoteController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @GetMapping
    public List<Vote> getAll() {
        return voteRepository.findAll();
    }
}