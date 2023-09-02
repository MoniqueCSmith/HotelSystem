/**
 * Room.java
 * Entity for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 25 March 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Room implements Serializable {

    @Id
    private String roomNo;
    private String roomType;
    private boolean isRoomAvailable;

    protected Room(){}
    private Room(Builder builder){
        this.roomNo = builder.roomNo;
        this.roomType = builder.roomType;
        this.isRoomAvailable = builder.isRoomAvailable;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isRoomAvailable() {
        return isRoomAvailable;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomAvailable(boolean roomAvailable) {
        this.isRoomAvailable = roomAvailable;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNo='" + roomNo + '\'' +
                ", roomType='" + roomType + '\'' +
                ", isRoomAvailable=" + isRoomAvailable +
                '}';
    }

    public static class Builder {
        public String roomNo;
        public String roomType;
        public boolean isRoomAvailable;

        public Builder setRoomNo(String roomNo) {
            this.roomNo = roomNo;
            return this;
        }

        public Builder setRoomType(String roomType) {
            this.roomType = roomType;
            return this;
        }

        public Builder setRoomAvailable(boolean roomAvailable) {
            this.isRoomAvailable = roomAvailable;
            return this;
        }

        public Builder copy(Room room) {
            this.roomNo = room.roomNo;
            this.roomType = room.roomType;
            this.isRoomAvailable = room.isRoomAvailable;
            return this;

        }

        public Room build() {
            return new Room(this);

        }
    }
}
