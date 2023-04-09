/**
 * RoomRepository.java
 * Repository class for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Room;
import java.util.HashSet;
import java.util.Set;

public class RoomRepository implements IRoomRepository {
    private static RoomRepository repository = null;
    private Set<Room> roomDB = null;

    private RoomRepository(){
        roomDB = new HashSet<Room>();
    }
    public static RoomRepository getRepository(){
        if(repository == null) {
            repository = new RoomRepository();
        }
        return repository;

    }
    @Override
    public Room create(Room room) {
        boolean success = roomDB.add(room);
        if(!success)
            return null;
        return room;

    }

    @Override
    public Room read(String roomNo) {
        for (Room a : roomDB) {
            if (a.getRoomNo().equals(roomNo))
                return a;
        }
        return null;

    }

    @Override
    public Room update(Room room) {
        Room oldRoom = read(room.getRoomNo());
        if(oldRoom != null){
            roomDB.remove(oldRoom);
            roomDB.add(room);
            return room;
        }
        return null;
    }

    @Override
    public boolean delete(String roomNo) {
        Room roomToDelete = read(roomNo);
        if(roomToDelete == null)
            return false;
        roomDB.remove(roomToDelete);
        return true;
    }
    @Override
    public Set<Room> getAll() {
        return roomDB;
    }
}
