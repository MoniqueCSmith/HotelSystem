/**
 * RoomController.java
 * Controller class for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 13 June 2023
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Room;
import za.ac.cput.util.factory.RoomFactory;
import za.ac.cput.service.impl.RoomServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;

    @PostMapping("/create")
    public Room create(@RequestBody Room room){
        Room roomCreated = RoomFactory.buildRoom(room.getRoomType(), room.isRoomAvailable());
        return roomService.create(roomCreated);

    }

    @GetMapping("/read/{id}")
    public Room read(@PathVariable String id){
        return roomService.read(id);
    }

    @PostMapping("/update")
    public Room update(@RequestBody Room room){
        return roomService.update(room);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return roomService.delete(id);
    }

    @RequestMapping("/getall")
    public List<Room> getall(){
        return roomService.getAll();
    }
}