/**
 * RoomFactory.java
 * Factory Class for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 04 April 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Room;
import za.ac.cput.domain.RoomType;
import za.ac.cput.util.Helper;

public class RoomFactory {
    public static Room buildRoom(RoomType roomType, double price){
        if(Helper.isNullOrEmpty(String.valueOf(roomType)) || Helper.isNullOrEmpty(String.valueOf(price))) {
            return null;
        }

        if(Helper.isValidDouble(price)){
            return null;
        }

        String roomNo = Helper.generateRoomNo();

        return new Room.Builder()
                .setRoomNo(roomNo)
                .setRoomType(roomType)
                .setPrice(price)
                .build();

    }
}
