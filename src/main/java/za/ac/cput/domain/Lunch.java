package za.ac.cput.domain;

public class Lunch extends RoomService{
    public Lunch() {
    }

    public Lunch(String roomServiceId, String description, int quantity, double price, double roomServiceTotal) {
        super(roomServiceId, description, quantity, price, roomServiceTotal);
    }
}
