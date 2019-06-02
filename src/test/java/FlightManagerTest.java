import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FlightManagerTest {

    private Plane plane1;
    private Plane plane2;
    private Flight flight1;
    private Flight flight2;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;
    private Passenger passenger4;
    private Passenger passenger5;
    private FlightManager flightManager;

    @Before
    public void setUp() {
        plane1 = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.CREATIVEPLANENAMEFORTESTINGSEARCH);
        flight1 = new Flight(plane1, "FR213", AirportCode.PRG, AirportCode.DUB);
        flight1.determineSeatNumbers();
        flight1.setDepartureTime(2019, 6, 25, 13, 00, 00);
        flight2 = new Flight(plane2, "FR213", AirportCode.CDG, AirportCode.GLA);
        flight2.determineSeatNumbers();
        flight2.setDepartureTime(2019, 6, 25, 17, 00, 00);
        passenger1 = new Passenger("Dave", 2);
        passenger2 = new Passenger("Gemma", 1);
        passenger3 = new Passenger("Pablo", 1);
        passenger4 = new Passenger("Lauren", 1);
        passenger5 = new Passenger("James", 1);
        flightManager = new FlightManager();
    }

    @Test
    public void canDetermineWeightReservedForBaggage() {
        assertEquals(10, flightManager.reservedBagWeight(flight1));
    }

    @Test
    public void canDetermineHowMuchBaggageWeightIsCurrentlyBooked__NoPassengers() {
    assertEquals(0, flightManager.bookedBagWeight(flight1));
    }

    @Test
    public void canCalculateIndividualBagWeight() {
        assertEquals(2, flightManager.calculateBagWeight(flight1));
    }

    @Test
    public void canDetermineHowMuchBaggageWeightIsCurrentlyBooked__WithPassengers() {
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger2);
        assertEquals(6, flightManager.bookedBagWeight(flight1));
    }

    @Test
    public void canDetermineRemainingWeightReservedForBaggage() {
        flight1.bookPassenger(passenger1);
        assertEquals(6, flightManager.remainingBagWeight(flight1));
    }

    @Test
    public void canBookPassengerOntoPlane() {
        flightManager.bookPassengerOnFlight(flight1, passenger1);
        assertEquals(1, flight1.getPassengers());
        assertEquals(4, flightManager.bookedBagWeight(flight1));
        assertEquals(6, flightManager.remainingBagWeight(flight1));
        assertEquals("FR213", passenger1.getFlight());
    }

    @Test
    public void cannotBookPassengerOntoPlane__BagsOverWeight() {
        flightManager.bookPassengerOnFlight(flight1, passenger1);
        flightManager.bookPassengerOnFlight(flight1, passenger1);
        flightManager.bookPassengerOnFlight(flight1, passenger1);
        assertEquals(2, flight1.getPassengers());
        assertEquals(8, flightManager.bookedBagWeight(flight1));
        assertEquals(2, flightManager.remainingBagWeight(flight1));
    }

    @Test
    public void canSortPassengersBySeatNumber() {
        flightManager.bookPassengerOnFlight(flight1, passenger1);
        flightManager.bookPassengerOnFlight(flight1, passenger2);
        flightManager.bookPassengerOnFlight(flight1, passenger3);
        flightManager.bookPassengerOnFlight(flight1, passenger4);
        assertEquals(4, flightManager.sortPassengersBySeatNumber(flight1).size());
    }

    @Test
    public void canFindAPassengerBySeatNumber() {
        flightManager.bookPassengerOnFlight(flight2, passenger1);
        flightManager.bookPassengerOnFlight(flight2, passenger2);
        flightManager.bookPassengerOnFlight(flight2, passenger3);
        flightManager.bookPassengerOnFlight(flight2, passenger4);
        flightManager.bookPassengerOnFlight(flight2, passenger5);
        ArrayList<Passenger> passengers = flight2.getPassengerList();
        assertNotEquals(null, flightManager.findPassengerBySeatNumber(passengers, 4));
    }
}
