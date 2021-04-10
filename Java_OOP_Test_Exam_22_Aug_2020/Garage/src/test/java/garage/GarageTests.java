package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class GarageTests {
    private Garage garage;
    private List<Car> testCars;

    @Before
    public void setUp() {
        garage = new Garage();
        testCars = new ArrayList<>();
    }

    @Test
    public void testGetCarsReturnsUnmodifiableCollectionOfCars() {
        List<Car> expected = List.of();
        List<Car> actual = garage.getCars();

        assertEquals(expected, actual);
    }

    @Test
    public void testAddCarShouldAddCarToCarCollection(){
        addCars();
        List<Car> expected = testCars;
        expected.add(new Car("Volvo", 300, 30000.99));
        expected.add(new Car("Peugeot", 190, 25400.99));
        expected.add(new Car("Volkswagen", 260, 28999.99));
        expected.add(new Car("Renault", 240, 32320.99));
        expected = Collections.unmodifiableList(expected);
        List<Car> actual = garage.getCars();

        listElementsCompare(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarShouldThrowExceptionIfCarIsNull(){
        garage.addCar(null);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAboveShouldReturnCarsWithMaxSpeedAboveGivenSpeed(){
        addCars();
        int maxSpeed = 200;
        List<Car> expectedCars = this.testCars.stream().filter(c -> c.getMaxSpeed() > maxSpeed).collect(Collectors.toList());
        List<Car> actualCars = garage.findAllCarsWithMaxSpeedAbove(maxSpeed);

        listElementsCompare(expectedCars, actualCars);
    }

    @Test
    public void testGetTheMostExpensiveCarShouldReturnNullWhenNoCarPresent(){
        assertNull(garage.getTheMostExpensiveCar());
    }

    @Test
    public void testGetTheMostExpensiveCarShouldReturnMostExpensiveCar(){
        addCars();
        Car actualCar = garage.getTheMostExpensiveCar();
        Car expectedCar = testCars.stream()
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
                .limit(1)
                .findFirst()
                .orElse(null);

        assertEquals(expectedCar.getBrand(), actualCar.getBrand());
        assertEquals(expectedCar.getMaxSpeed(), actualCar.getMaxSpeed());
        assertEquals(expectedCar.getPrice(), actualCar.getPrice(), 0);
    }

    @Test
    public void testFindAllCarsByBrandShouldReturnAllCarsByBrand(){
        addCars();
        String brand = "Volvo";
        List<Car> actual = garage.findAllCarsByBrand(brand);
        List<Car> expected = testCars.stream().filter(c -> c.getBrand().equals(brand)).collect(Collectors.toList());

        listElementsCompare(expected, actual);
    }

    @Test
    public void getGetCountShouldReturnCarCount(){
        addCars();
        assertEquals(garage.getCount(), testCars.size());
    }

    public void addCars(){
        testCars.add(new Car("Volvo", 300, 30000.99));
        testCars.add(new Car("Peugeot", 190, 25400.99));
        testCars.add(new Car("Volkswagen", 260, 28999.99));
        testCars.add(new Car("Renault", 240, 32320.99));

        garage.addCar(new Car("Volvo", 300, 30000.99));
        garage.addCar(new Car("Peugeot", 190, 25400.99));
        garage.addCar(new Car("Volkswagen", 260, 28999.99));
        garage.addCar(new Car("Renault", 240, 32320.99));
    }

    private void listElementsCompare(List<Car> expected, List<Car> actual) {
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getBrand(), actual.get(i).getBrand());
            assertEquals(expected.get(i).getMaxSpeed(), actual.get(i).getMaxSpeed());
            assertEquals(expected.get(i).getPrice(), actual.get(i).getPrice(), 0);
        }
    }
}