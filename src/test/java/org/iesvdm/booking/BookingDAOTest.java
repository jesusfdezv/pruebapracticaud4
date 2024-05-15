package org.iesvdm.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class BookingDAOTest {

    private BookingDAO bookingDAO;
    private Map<String, BookingRequest> bookings;

    @BeforeEach
    public void setup() {
        bookings = new HashMap<>();
        bookingDAO = new BookingDAO(bookings);
    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas (bookings) con la que
     * construyes el objeto BookingDAO bajo testeo.
     * Comprueba que cuando invocas bookingDAO.getAllBookingRequest
     * obtienes las 2 peticiones.
     */
    @Test
    void  getAllBookingRequestsTest() {
        BookingRequest request1 = new BookingRequest("1",null,null,1,true);
        BookingRequest request2 = new BookingRequest("2",null,null,2,true);
        bookingDAO.save(request1);
        bookingDAO.save(request2);

        System.out.println(bookingDAO.getAllBookingRequests().toString());
    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.getAllUUIDs
     * obtienes las UUIDs de las 2 peticiones guardadas.
     */
    @Test
    void getAllUUIDsTest() {
        BookingRequest request1 = new BookingRequest("1",null,null,1,true);
        BookingRequest request2 = new BookingRequest("2",null,null,2,true);
        bookingDAO.save(request1);
        bookingDAO.save(request2);

        System.out.println(bookingDAO.getAllUUIDs().toString());
    }


    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.get con el UUID
     * obtienes las respectivas 2 peticiones guardadas.
     */
    @Test
    void getTest() {
        BookingRequest request1 = new BookingRequest("1",null,null,1,true);
        BookingRequest request2 = new BookingRequest("2",null,null,2,true);
        bookingDAO.save(request1);
        bookingDAO.save(request2);

        System.out.println(bookingDAO.get(bookingDAO.save(request1)));

    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * A continuación, borra la primera y comprueba
     * que se mantiene 1 reserva, la segunda guardada.
     */
    @Test
    void deleteTest() {
        BookingRequest request1 = new BookingRequest("1",null,null,1,true);
        BookingRequest request2 = new BookingRequest("2",null,null,2,true);
        bookingDAO.save(request1);
        bookingDAO.save(request2);

        bookingDAO.delete(bookingDAO.save(request1));

        System.out.println(bookingDAO.totalBookings());
        System.out.println(bookingDAO.getAllBookingRequests().toString());
    }

    /**
     * Guarda 2 veces la misma petición de reserva (BookingRequest)
     * y demuestra que en la colección de bookings están repetidas
     * pero con UUID diferente
     *
     */
    @Test
    void saveTwiceSameBookingRequestTest() {
        BookingRequest request1 = new BookingRequest("1",null,null,1,true);
        BookingRequest request2 = new BookingRequest("1",null,null,1,true);
        bookingDAO.save(request1);
        bookingDAO.save(request2);

        System.out.println();
        System.out.println(bookingDAO.getAllUUIDs().toString());
    }

}
