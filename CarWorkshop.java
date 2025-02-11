import java.util.List;
import java.util.ArrayList;

public class CarWorkshop <T extends Vehicle>{
    private int capacity;
    private int nrCars;
    private List<T> vehicles = new ArrayList<>();

    public CarWorkshop(int capacity) {
        this.capacity = capacity;
    }

    public void turnInCar(T vehicle) {
        if (nrCars < this.capacity) {
            vehicles.add(vehicle);
            nrCars += 1;
        } else {
            throw new IllegalStateException("The workshop is full!");
        }
    }

    public T removeCar (int index) {
        T removedCar = null;
        if (index >= 0 && index < vehicles.size()) {
            removedCar = vehicles.get(index);
            vehicles.remove(index);
            nrCars -= 1;
            return removedCar;
        } else {
            throw new IllegalArgumentException("Wrong index!");
        }
    }
    public int getNrCars() {return nrCars;}
}
