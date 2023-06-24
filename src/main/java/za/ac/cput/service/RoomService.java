package za.ac.cput.service;


import za.ac.cput.domain.Room;

import java.util.List;


public interface RoomService extends IService <Room, String>{
    List<Room> getAll();
}
