/**
 RoomService.java
 Service interface for the Room
 Author: Alison Shirlene Williams (219140987)
 Date: 09 June 2023
 */
package za.ac.cput.service;


import za.ac.cput.domain.Room;

import java.util.Set;

public interface RoomService extends IService <Room, String>{
    Set<Room> getAll();
}
