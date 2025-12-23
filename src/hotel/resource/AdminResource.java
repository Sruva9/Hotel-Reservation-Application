package hotel.resource;

import hotel.model.Customer;
import hotel.model.Room;
import hotel.service.CustomerService;
import hotel.service.ReservationService;

import java.util.Collection;

public class AdminResource {

    private final CustomerService customerService =
            CustomerService.getInstance();

    private final ReservationService reservationService =
            ReservationService.getInstance();

    public void addRoom(Room room) {
        reservationService.addRoom(room);
    }

    public Collection<Room> getAllRooms() {
        return reservationService.findRooms(
                new java.util.Date(0),
                new java.util.Date(Long.MAX_VALUE)
        );
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers().values();
    }

    public Collection<?> getAllReservations() {
        return reservationService.getAllReservations();
    }
}