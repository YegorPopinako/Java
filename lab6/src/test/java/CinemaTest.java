import org.example.Cinema;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CinemaTest {

    private Cinema cinema;

    @Before
    public void setUp() {
        // Initialize the Cinema object before each test
        cinema = new Cinema(3, 5, 10);  // Adjust parameters as needed
    }

    @Test
    public void bookSeats_ValidBooking_ReturnsTrue() {
        int hallNumber = 0;
        int row = 2;
        int[] seats = {3, 4, 5};

        assertTrue(cinema.bookSeats(hallNumber, row, seats));
    }

    @Test
    public void bookSeats_SeatAlreadyBooked_ReturnsFalse() {
        int hallNumber = 0;
        int row = 2;
        int[] seats = {3, 4, 5};

        // First booking
        assertTrue(cinema.bookSeats(hallNumber, row, seats));

        // Attempting to book the same seats again
        assertFalse(cinema.bookSeats(hallNumber, row, seats));
    }

    @Test
    public void cancelBooking_ValidCancellation_ReturnsTrue() {
        int hallNumber = 1;
        int row = 3;
        int[] seats = {1, 2, 3};

        // Booking seats
        assertTrue(cinema.bookSeats(hallNumber, row, seats));

        // Cancelling the booking
        assertTrue(cinema.cancelBooking(hallNumber, row, seats));
    }

    @Test
    public void checkAvailability_AvailableSeats_ReturnsTrue() {
        int hallNumber = 2;
        int numSeats = 3;

        assertTrue(cinema.checkAvailability(hallNumber, numSeats));
    }

}