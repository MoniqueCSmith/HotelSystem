package za.ac.cput.service;


import za.ac.cput.domain.Room;

import java.util.Set;

public interface RoomService extends IService <Room, String>{
    Set<Room> getAll();
}
