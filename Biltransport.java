import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Biltransport extends ScaniaLastbil {

    private final static int maxLoad = 6;

    public Biltransport() {
        String[] cargo = new String[5];
    }


    //@Override
    protected void raiseTruckBed(){
        //fler safeguards här för errors och problem?? else
        //borde det finnas en else för att bara "pass"
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Truck must be stationary to raise or lower the truckbed");
        } else if (TruckBedAngle == 0){
            TruckBedAngle = 70;
        } else {
            throw new IllegalStateException("Truckbed is already raised");
        }
    }

    //@Override
    protected void lowerTruckBed() {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Truck must be stationary to raise or lower the truckbed");
        } else if (TruckBedAngle == 70) {
            TruckBedAngle = 0;
        } else {
            throw new IllegalStateException("Truckbed is already lowered");
        }
    }

    protected void loadCar(String car) {
        //placera vehicelModel på given plats i cargo arrayen
        //inom 10 meters avstånd
        //ramp måste vara nere
        //Bilstransporten får inte lastas på ett flak
        if (getCurrentSpeed() > 0 || TruckBedAngle != 0) {
            throw new IllegalStateException(
                    "Truck must be both stationary and with the truckbed lowered to load cars.");
        } else if (Math.abs(this.getX - car.getX) >= 10 && Math.abs(this.getY - car.getY >= 10)) {
            //tanken rätt här men kommer ju inte funka
            throw new IllegalStateException(
                    "Car must be within 10 meters of the truck to be loaded.");
        } else {
            cargo[0] = car;
        }
    }

    protected void unLoadCar(String car) {
        //ska denna funktion bara automatiskt lasta av den nästa i tur på lasten? behövs då någon vehiclemodel variabel
        //måste stå still

    }
}
