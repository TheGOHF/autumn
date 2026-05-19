package ru.bgpu.autumn.services;

import org.springframework.stereotype.Service;
import ru.bgpu.autumn.models.Tag;
import ru.bgpu.autumn.repositories.TagRepository;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }
}