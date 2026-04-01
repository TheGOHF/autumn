package ru.bgpu.autumn.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bgpu.autumn.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}
