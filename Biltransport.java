import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Biltransport extends Vehicle {

    private Lastbil Lastbil;
    private int loadPosition = 0;
    List<Vehicle> cargo = new ArrayList<>(); //detta bättre?


    public Biltransport(int loadCapacity) {
        super ("Biltransport", 2, 175,"North", Color.red);
        //String[] cargo = new String[loadCapacity];
        Lastbil = new Lastbil(0,1);
    }


    protected void raiseTruckBed(){
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException
                    ("Truck must be stationary to raise or lower the truckbed");
        } else if (Lastbil.getAngle() == Lastbil.getMin()){
            Lastbil.setAngle(Lastbil.getMax());
        } else {
            throw new IllegalStateException
                    ("Truckbed is already raised");
        }
    }

    protected void lowerTruckBed() {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException
                    ("Truck must be stationary to raise or lower the truckbed");
        } else if (Lastbil.getAngle() == Lastbil.getMax()) {
            Lastbil.setAngle(Lastbil.getMin());
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
        if (this.getCurrentSpeed() > 0 || Lastbil.getAngle() != 0) {
            throw new IllegalStateException(
                    "Truck must be both stationary and with the truckbed lowered to load cars.");
        } else if (Math.abs(this.getX() - car.getX()) >= 10 && Math.abs(this.getY() - car.getY()) >= 10) {
            //hur använder jag getX() på car här så att jag kna jämföra x och y värden?
            throw new IllegalStateException(
                    "Car must be within 10 meters of the truck to be loaded.");
        } else if (car instanceof Biltransport) {
            System.out.println("Fel! kan inte lasta en annan biltransport!");
        } else {
            //hur får jag cargo till att bli använd här?
            cargo.set(loadPosition, car);
            loadPosition += 1;
        }
    }

    protected void unLoadCar(Vehicle car) {
        //ska denna funktion bara automatiskt lasta av den nästa i tur på lasten? behövs då någon car variabel?
        //måste stå still
        //måste fixa så att lasten förflyttas med samma x oxh y koordinater
        if (this.getCurrentSpeed() > 0) {
            throw new IllegalStateException(
                    "Truck must be both stationary and with the truckbed lowered to load cars.");
        } else {
            //lägga till att bilen inte har exakt samma koordinater
            loadPosition -= 1;
            cargo.get(loadPosition).setPosition(5, 5);
            cargo.remove(loadPosition);

        }
    }

    @Override
    public void move() {
        switch (direction) {
            case "North":
                y += this.getCurrentSpeed();
                for (int i=0; i<cargo.size(); i++) {
                    cargo.get(i).setPosition(0, this.getCurrentSpeed());}
                break;
            case "East":
                x += this.getCurrentSpeed();
                for (int i=0; i<cargo.size(); i++) {
                    cargo.get(i).setPosition(this.getCurrentSpeed(), 0);}
                    break;
            case "South":
                y -= this.getCurrentSpeed();
                for (int i=0; i<cargo.size(); i++) {
                    cargo.get(i).setPosition(0, -(this.getCurrentSpeed()));}
                    break;
            case "West":
                x -= this.getCurrentSpeed();
                for (int i=0; i<cargo.size(); i++) {
                    cargo.get(i).setPosition(-(this.getCurrentSpeed()), 0);}
                    break;
        }

    }

    @Override
    protected double speedFactor() { return enginePower * 0.01;}
}