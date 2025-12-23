package hotel.service;

import hotel.model.*;

import java.util.*;

public class ReservationService {

    private static final ReservationService instance = new ReservationService();

    private final Set<Room> rooms = new HashSet<>();

    private final List<Reservation> reservations = new ArrayList<>();

    private ReservationService() {}

    public static ReservationService getInstance() {
        return instance;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> findRooms(Date checkIn, Date checkOut) {
        List<Room> availableRooms = new ArrayList<>();

        for (Room room : rooms) {
            boolean isAvailable = true;

            for (Reservation reservation : reservations) {
                if (reservation.getRoom().equals(room)) {

                    if (checkIn.before(reservation.getCheckOutDate())
                            && checkOut.after(reservation.getCheckInDate())) {
                        isAvailable = false;
                        break;
                    }
                }
            }

            if (isAvailable) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void reserveRoom(Customer customer, Room room,
                            Date checkIn, Date checkOut) {
        reservations.add(new Reservation(customer, room, checkIn, checkOut));
    }

    public Collection<Reservation> getCustomerReservations(Customer customer) {
        List<Reservation> result = new ArrayList<>();

        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().equals(customer)) {
                result.add(reservation);
            }
        }
        return result;
    }

    public Collection<Reservation> getAllReservations() {
        return reservations;
    }
}