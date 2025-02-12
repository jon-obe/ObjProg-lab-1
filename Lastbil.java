public class Lastbil {

    protected int min;
    protected int max;
    protected int TruckBedAngle = 0;

    public Lastbil(int min, int max) {
        this.min = min;
        this.max = max;

    }
    public int getTruckBedAngle() {return TruckBedAngle;}

    public void setAngle(int angle) {
        if(angle >= this.min && angle <= this.max) {
            TruckBedAngle = angle;
        }
    }
}
