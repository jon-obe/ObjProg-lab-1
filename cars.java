import java.awt.*;

public class cars implements movable{

    protected int nrDoors; // Number of doors on the car, only subclasses can access, but you need to use getter and setter
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double speedFactor;

    protected double x;
    protected double y;
    protected String direction;


    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected void setDirection(String dir) {direction = dir;}

    public String getDirection() {return direction;}

    protected double speedFactor(){ return enginePower * 0.01; }

    public void move() {
        switch (direction) {
            case "North": y += currentSpeed;
            break;
            case "East": x+=currentSpeed;
            break;
            case "South": y -= currentSpeed;
            break;
            case "West": x-=currentSpeed;
            break;
        }

    }

    public void turnLeft() {
        System.out.println(direction);
        switch (direction) {
            case "North":
                setDirection("West");
                break;
            case "East":
                setDirection("North");
                break;
            case "South":
                setDirection("East");
                break;
            case "West":
                setDirection("South");
                break;
        }
        System.out.println(direction);

    }

    public void turnRight() {
            switch (direction) {
                case "North": setDirection("East");
                break;
                case "East": setDirection("South");
                break;
                case "South": setDirection("West");
                break;
                case "West": setDirection("North");
                break;
        }
    }

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount){
        if (amount > 0 && amount < 1) {
            incrementSpeed(amount);}
    }

    public void brake(double amount){
        if (amount > 0 && amount < 1){
            decrementSpeed(amount);}
    }
}

