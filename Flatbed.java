public class Flatbed {

    protected int min;
    protected int max;
    private int flatBedAngle = 0;

    public Flatbed(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public int getAngle() {return flatBedAngle;}

    public void setAngle(int angle) {
        if(angle >= this.min && angle <= this.max){
            flatBedAngle = angle;
        }
    }
}
