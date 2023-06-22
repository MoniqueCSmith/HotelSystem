/**
 * RoomFactory.java
 * Factory Class for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 04 April 2023
 */

package za.ac.cput.util.factory;

import za.ac.cput.domain.Room;
import za.ac.cput.util.Helper;

public class RoomFactory {
    public static Room buildRoom(String roomType, boolean isRoomAvailable){
        if(Helper.isNullOrEmpty(roomType) || Helper.isNullOrEmpty(String.valueOf(isRoomAvailable))) {
            return null;
        }

        String roomNo = Helper.generateRoomNo();

        return new Room.Builder()
                .setRoomNo(roomNo)
                .setRoomType(roomType)
                .setRoomAvailable(isRoomAvailable)
                .build();

    }
}
