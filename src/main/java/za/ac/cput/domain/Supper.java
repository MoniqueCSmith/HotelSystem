package za.ac.cput.domain;

public class Supper extends RoomService{
    public Supper() {
    }

    public Supper(String roomServiceId, String description, int quantity, double price, double roomServiceTotal) {
        super(roomServiceId, description, quantity, price, roomServiceTotal);
    }


}
