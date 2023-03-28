package za.ac.cput.domain;

import java.util.Objects;

public class RoomService {
    private String roomServiceId;
    private String  description;
    private int quantity;
    private double price;
    private double roomServiceTotal;

    public RoomService() {
    }

    public RoomService(String roomServiceId, String description, int quantity, double price, double roomServiceTotal) {
        this.roomServiceId = roomServiceId;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.roomServiceTotal = price * quantity;
    }

    public String getRoomServiceId() {
        return roomServiceId;
    }

    public void setRoomServiceId(String roomServiceId) {
        this.roomServiceId = roomServiceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRoomServiceTotal() {
        return price * quantity;
    }

    public void setRoomServiceTotal(double roomServiceTotal) {
        this.roomServiceTotal = price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomService that = (RoomService) o;
        return quantity == that.quantity && Double.compare(that.price, price) == 0 && Double.compare(that.roomServiceTotal, roomServiceTotal) == 0 && Objects.equals(roomServiceId, that.roomServiceId) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomServiceId, description, quantity, price, roomServiceTotal);
    }

    @Override
    public String toString() {
        return "RoomService{" +
                "roomServiceId='" + roomServiceId + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", roomServiceTotal=" + roomServiceTotal +
                '}';
    }

}
