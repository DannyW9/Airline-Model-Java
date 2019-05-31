import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void setUp() {
        passenger = new Passenger("Dave", 2);
    }

    @Test
    public void hasName() {
        assertEquals("Dave", passenger.getName());
    }

    @Test
    public void hasBags() {
        assertEquals(2, passenger.getBags());
    }
}
