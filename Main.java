
public class Main{
    public static void main(String[] args) {
        CarWorkshop<Saab95> saabWorkshop = new CarWorkshop<>(2);

        Saab95 saab = new Saab95();
        Saab95 saab2 = new Saab95();

        saabWorkshop.turnInCar(saab);
        saabWorkshop.turnInCar(saab2);

        System.out.println(saabWorkshop.removeCar(0));
        System.out.println(saabWorkshop.getNrCars());

    }
}