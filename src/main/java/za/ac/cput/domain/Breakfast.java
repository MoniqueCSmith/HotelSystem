package za.ac.cput.domain;

public class Breakfast extends RoomService {
    public Breakfast() {
    }

    public Breakfast(String roomServiceId, String description, int quantity, double price, double roomServiceTotal) {
        super(roomServiceId, description, quantity, price, roomServiceTotal);
    }
}
