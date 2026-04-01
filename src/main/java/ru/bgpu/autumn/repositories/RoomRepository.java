package ru.bgpu.autumn.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bgpu.autumn.models.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
