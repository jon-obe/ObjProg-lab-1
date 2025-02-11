import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Biltransport extends Vehicle{

    private Flatbed flatbed;
    private int capacity;
    private int nrCars = 0;

    public Biltransport(int capacity) {
        this.capacity = capacity;
    }

    // @Override
    protected void RaiseTruckBed(){
        if (getCurrentSpeed() > 0) {
            System.out.println("Truck must be stationary to raise or lower the truckbed");
        } if (TruckBedAngle == 0){
            TruckBedAngle = 70;
        } else {;}

    }

    @Override
    protected double speedFactor() {
        return 0;
    }
}