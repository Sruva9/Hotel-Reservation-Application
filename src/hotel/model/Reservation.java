package hotel.model;

import java.util.Date;

public class Reservation {

    private final Customer customer;
    private final Room room;
    private final Date checkInDate;
    private final Date checkOutDate;

    public Reservation(Customer customer, Room room,
                       Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }
    @Override
    public String toString() {
        return "Room " + room.getRoomNumber() +
                " | " + room.getRoomType() +
                " | Check-in: " + checkInDate +
                " | Check-out: " + checkOutDate;
    }
}
