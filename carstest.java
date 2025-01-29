import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class carstest {

    @Test
    public void testMove() {
        Volvo240 v = new Volvo240();
        v.startEngine();
        assertEquals(0.1, v.getCurrentSpeed());
    }
    @Test
    public void testRight() {
        Saab95 s = new Saab95();
        s.startEngine();
        s.turnRight();
        assertEquals("East", s.getDirection());


    }
}