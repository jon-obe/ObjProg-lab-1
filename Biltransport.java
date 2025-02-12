import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Biltransport extends Vehicle {

    private Lastbil Lastbil;
    private int loadPosition = 0;


    public Biltransport(int loadCapacity) {
        super ("Biltransport", 2, 175,"North", Color.red);
        //String[] cargo = new String[loadCapacity];
        List<Vehicle> cargo = new ArrayList<>(); //detta bättre?
        Lastbil = new Lastbil(0,1);
    }


    protected void raiseTruckBed(){
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException
                    ("Truck must be stationary to raise or lower the truckbed");
        } else if (Lastbil.TruckBedAngle == Lastbil.min){
            Lastbil.TruckBedAngle = Lastbil.max;
        } else {
            throw new IllegalStateException
                    ("Truckbed is already raised");
        }
    }

    protected void lowerTruckBed() {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException
                    ("Truck must be stationary to raise or lower the truckbed");
        } else if (Lastbil.TruckBedAngle == Lastbil.max) {
            Lastbil.TruckBedAngle = Lastbil.min;
        } else {
            throw new IllegalStateException
                    ("Truckbed is already lowered");
        }
    }

    protected void loadCar(Vehicle car) {
        //placera vehicelModel på given plats i cargo arrayen
        //inom 10 meters avstånd
        //ramp måste vara nere
        //Bilstransporten får inte lastas på ett flak
        //this på currentspeed eller ej?
        if (this.getCurrentSpeed() > 0 || Lastbil.TruckBedAngle != 0) {
            throw new IllegalStateException(
                    "Truck must be both stationary and with the truckbed lowered to load cars.");
        } else if (Math.abs(this.getX() - car.getX()) >= 10 && Math.abs(this.getY() - car.getY()) >= 10) {
            //hur använder jag getX() på car här så att jag kna jämföra x och y värden?
            throw new IllegalStateException(
                    "Car must be within 10 meters of the truck to be loaded.");
        } else if { //behöver fixa så att den kollar att den inte lastar lastbilar här

        } else {
            //hur får jag cargo till att bli använd här?
            cargo[loadPosition] = car;
            loadPosition += 1;
        }
    }

    protected String unLoadCar(String car) {
        //ska denna funktion bara automatiskt lasta av den nästa i tur på lasten? behövs då någon car variabel?
        //måste stå still
        //måste fixa så att lasten förflyttas med samma x oxh y koordinater
        if (this.getCurrentSpeed() > 0) {
            throw new IllegalStateException(
                    "Truck must be both stationary and with the truckbed lowered to load cars.");
        } else {
            //lägga till att bilen inte har exakt samma koordinater
            loadPosition -= 1;
            cargo[loadPosition].setPosition(5, 5);
            return cargo.pop[loadPosition];

        }

    }

    @Override
    public void move() {
        switch (direction) {
            case "North":
                y += this.getCurrentSpeed();
                //lägga till så att alla bilar på lasten också förflyttas
                break;
            case "East":
                x += this.getCurrentSpeed();
                break;
            case "South":
                y -= this.getCurrentSpeed();
                break;
            case "West":
                x -= this.getCurrentSpeed();
                break;
        }

    }

    @Override
    protected double speedFactor() { return enginePower * 0.01;}
}
