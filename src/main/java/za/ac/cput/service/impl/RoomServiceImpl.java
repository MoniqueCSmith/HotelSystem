/**
 * RoomServiceImpl.java
 * Service class for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Room;
import za.ac.cput.repository.IRoomRepository;
import za.ac.cput.service.RoomService;

import java.util.List;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {
    private IRoomRepository repository;

    @Autowired
    private RoomServiceImpl(IRoomRepository repository){
        this.repository = repository;
    }
    @Override
    public Room create(Room room) {
        return this.repository.save(room);
    }

    @Override
    public Room read(String roomNo) {
        return this.repository.findById(roomNo).orElse(null);
    }

    @Override
    public Room update(Room room) {
        if(this.repository.existsById(room.getRoomNo()))
            return this.repository.save(room);
        return null;
    }

    @Override
    public boolean delete(String roomNo) {
        if(this.repository.existsById(roomNo)) {
            this.repository.deleteById(roomNo);
            return true;
        }
        return false;

    }

    @Override
    public List<Room> getAll() {
        return this.repository.findAll();
    }
}
