package hotel.resource;

import hotel.model.Customer;
import hotel.model.Room;
import hotel.service.CustomerService;
import hotel.service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    private final CustomerService customerService =
            CustomerService.getInstance();

    private final ReservationService reservationService =
            ReservationService.getInstance();

    public void createCustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public Collection<Room> findARoom(Date checkIn, Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

    public void bookARoom(Customer customer, Room room,
                          Date checkIn, Date checkOut) {
        reservationService.reserveRoom(customer, room, checkIn, checkOut);
    }

    public Collection<?> getCustomerReservations(Customer customer) {
        return reservationService.getCustomerReservations(customer);
    }
}