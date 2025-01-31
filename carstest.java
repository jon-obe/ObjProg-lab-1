import org.junit.Test;
import java.awt.*;

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

    @Test
    public void testGas() {
        Volvo240 v = new Volvo240();
        v.startEngine();
        assertThrows(IllegalAccessException.class, () -> v.gas(2));
        assertNotEquals(2.1 ,v.getCurrentSpeed());
    }
}