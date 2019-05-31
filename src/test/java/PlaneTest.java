import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void setUp() {
        plane = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void hasCapacity() {
        assertEquals(5, plane.getCapacity());
    }

    @Test
    public void hasTotalWeight() {
        assertEquals(20, plane.getTotalWeight());
    }
}
