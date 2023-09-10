/**
 * Room.java
 * Entity for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 25 March 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Room implements Serializable {

    @Id
    private String roomNo;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private double price;

    public static int currentRoomNumber = 101;
    protected Room(){}
    private Room(Builder builder){
        this.roomNo = builder.roomNo;
        this.roomType = builder.roomType;
        this.price = builder.price;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Double.compare(room.price, price) == 0 && Objects.equals(roomNo, room.roomNo) && roomType == room.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNo, roomType, price);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNo='" + roomNo + '\'' +
                ", roomType=" + roomType +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        public String roomNo;
        public RoomType roomType;
        private double price;

        public Builder setRoomNo(String roomNo) {
            this.roomNo = roomNo;
            return this;
        }

        public Builder setRoomType(RoomType roomType) {
            this.roomType = roomType;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(Room room) {
            this.roomNo = room.roomNo;
            this.roomType = room.roomType;
            this.price = room.price;
            return this;

        }

        public Room build() {
            return new Room(this);

        }
    }
}
