import java.awt.*;

public class ScaniaLastbil extends Vehicle {

    public final int TruckBedAngle = 0;

    public Scania(){
        super("Scania", 4, 175, "North", Color.blue)
        stopEngine();
    }

    protected void RaiseTruckBed(int degrees) {
        if (getCurrentSpeed() > 0) {
            System.out.println("Truck must be stationary to raise or lower the truckbed");
        } else if (degrees < 0 || degrees > 70){
            System.out.println("Invalid integer. Must be within the limits 0-70");
        } else if (TruckBedAngle + degrees >= 70) {
            TruckBedAngle = 70;
        } else {
            TruckBedAngle += degrees;
        }
    }

    protected void LowerTruckBed(int degrees) {
        //ska det vara en this. före currentspeed eller ska den skrivas om med en getter?
        //känns som det inte ska returnas strings här utan borde ge något annat, eller vara ett annat typ av fall.
        if (getCurrentSpeed() > 0){
            System.out.println("Truck must be stationary to raise or lower the truckbed");
        } else if (degrees < 0 || degrees > 70){
            System.out.println("Invalid integer. Must be within the limits 0-70");
        } else if (TruckBedAngle + degrees <= 0) {
            TruckBedAngle = 0;
        } else {
            TruckBedAngle -= degrees;
        }
    }

}
