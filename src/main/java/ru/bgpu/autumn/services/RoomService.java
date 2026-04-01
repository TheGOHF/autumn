package ru.bgpu.autumn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bgpu.autumn.models.Room;
import ru.bgpu.autumn.repositories.RoomRepository;

@Service
public class RoomService {

    @Autowired RoomRepository roomRepository;

    public Room save(Room room) {
        return roomRepository.save(room);
    }
}
