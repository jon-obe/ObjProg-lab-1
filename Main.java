
public class Main{
    public static void main(String[] args) {
        CarWorkshop<Saab95> saabWorkshop = new CarWorkshop<>(2);

        Saab95 saab = new Saab95();
        Saab95 saab2 = new Saab95();
        Volvo240 volvo = new Volvo240();

        saabWorkshop.turnInCar(saab);
        saabWorkshop.turnInCar(saab2);

        System.out.println(saabWorkshop.nrCars);

    }
}