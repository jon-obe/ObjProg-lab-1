import java.util.List;
import java.util.ArrayList;

public class CarWorkshop <T extends Vehicle>{
    public int capacity;
    public int nrCars;
    private List<T> vehicles = new ArrayList<>();

    public CarWorkshop(int capacity) {
        this.capacity = capacity;
    }

    public void turnInCar(T vehicle) {
        if (nrCars < this.capacity) {
            vehicles.add(vehicle);
            nrCars +=1;}
        else {
            throw new IllegalArgumentException("The workshop is full!");
        }
    }
}
