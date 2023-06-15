/**
 * RoomServiceImpl.java
 * Service class for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;


import org.springframework.stereotype.Service;
import za.ac.cput.domain.Room;
import za.ac.cput.repository.impl.RoomRepositoryImpl;
import za.ac.cput.service.RoomService;

import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {
    private static RoomServiceImpl service = null;
    private RoomRepositoryImpl repository = null;

    private RoomServiceImpl(){
        if(repository == null) {
            repository = RoomRepositoryImpl.getRepository();
        }
    }
    public static RoomServiceImpl getService() {
        if (service == null) {
            service = new RoomServiceImpl();
        }
        return service;
    }

    @Override
    public Room create(Room room) {
        return repository.create(room);
    }

    @Override
    public Room read(String id) {
        return repository.read(id);
    }

    @Override
    public Room update(Room room) {
        return repository.update(room);
    }

    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }
    @Override
    public Set<Room> getAll() {
        return repository.getAll();
    }
}
