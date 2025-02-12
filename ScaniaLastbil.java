import java.awt.*;

public class ScaniaLastbil extends Vehicle {

    public int TruckBedAngle = 0;

    public ScaniaLastbil(){
        super("Scania", 2, 175, "North", Color.blue);
        stopEngine();
    }

    protected void raiseTruckBed(int degrees) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Truck must be stationary to raise or lower the truckbed");
        } if (degrees < 0 || degrees > 70){
            throw new IllegalArgumentException("Invalid integer. Must be within the limits 0-70");
        } else if (TruckBedAngle + degrees >= 70) {
            TruckBedAngle = 70;
        } else {
            TruckBedAngle += degrees;
        }
    }

    protected void lowerTruckBed(int degrees) {
        //ska det vara en this. före currentspeed eller ska den skrivas om med en getter?
        //känns som det inte ska returnas strings här utan borde ge något annat, eller vara ett annat typ av fall.
        if (this.getCurrentSpeed() > 0){
            throw new IllegalStateException("Truck must be stationary to raise or lower the truckbed");
        } else if (degrees < 0 || degrees > 70){
            throw new IllegalArgumentException("Invalid integer. Must be within the limits 0-70");
        } else if (TruckBedAngle + degrees <= 0) {
            TruckBedAngle = 0;
        } else {
            TruckBedAngle -= degrees;
        }
    }

    @Override
    protected double speedFactor() {return enginePower * 0.01;}

}
