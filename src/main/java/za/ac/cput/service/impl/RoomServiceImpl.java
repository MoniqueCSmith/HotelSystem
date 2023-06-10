package za.ac.cput.service.impl;


import za.ac.cput.domain.Room;
import za.ac.cput.repository.RoomRepository;
import za.ac.cput.service.RoomService;

import java.util.Set;

public class RoomServiceImpl implements RoomService {
    private static RoomServiceImpl service = null;
    private RoomRepository repository = null;

    private RoomServiceImpl(){
        if(repository == null) {
            repository = RoomRepository.getRepository();
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
    public Room read(Room id) {
        return repository.read(id.getRoomNo());
    }

    @Override
    public Room update(Room room) {
        return repository.update(room);
    }

    @Override
    public boolean delete(Room id) {
        return repository.delete(id.getRoomNo());
    }
    @Override
    public Set<Room> getAll() {
        return repository.getAll();
    }
}
