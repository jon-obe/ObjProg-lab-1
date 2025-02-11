import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Carstest {

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


    @Test
    public void testCarWorkshop() {
        CarWorkshop<Saab95> saabWorkshop = new CarWorkshop<>(1);
        Saab95 saab = new Saab95();
        Saab95 saab2 = new Saab95();
        saabWorkshop.turnInCar(saab);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {saabWorkshop.turnInCar(saab2);});
        assertEquals("The workshop is full!", exception.getMessage());
    }
}