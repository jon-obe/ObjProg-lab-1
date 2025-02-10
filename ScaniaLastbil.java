import java.awt.*;

public class ScaniaLastbil extends Vehicle {

    public int TruckBedAngle = 0;

    public ScaniaLastbil(){
        super("Scania", 2, 175, "North", Color.blue);
        stopEngine();
    }

    protected void RaiseTruckBed(int degrees) {
        if (getCurrentSpeed() > 0) {
            System.out.println("Truck must be stationary to raise or lower the truckbed");
        } if (degrees < 0 || degrees > 70){
            System.out.println("Invalid integer. Must be within the limits 0-70");
        } else if (TruckBedAngle + degrees >= 70) {
            TruckBedAngle = 70;
        } else {
            TruckBedAngle += degrees;
        }
    }

    protected void LowerTruckBed(int degrees) {
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

    @Override
    protected double speedFactor() {return enginePower * 0.01;}

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }
}
