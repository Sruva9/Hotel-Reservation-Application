package hotel.model;

import java.util.Objects;

public class Room {

    private final String roomNumber;
    private final Double price;
    private final RoomType roomType;

    public Room(String roomNumber, Double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Double getPrice() {
        return price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return roomNumber.equals(room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }

    @Override
    public String toString() {
        return "Room " + roomNumber +
                " | " + roomType +
                " | " + (price == 0 ? "Free" : "$" + price);
    }
}