import java.awt.*;

public class Biltransport extends ScaniaLastbil {


    @Override
    protected void RaiseTruckBed(){
        if (getCurrentSpeed() > 0) {
            System.out.println("Truck must be stationary to raise or lower the truckbed");
        } if (TruckBedAngle == 0){
            TruckBedAngle = 70;
        } else {;}

    }
}
