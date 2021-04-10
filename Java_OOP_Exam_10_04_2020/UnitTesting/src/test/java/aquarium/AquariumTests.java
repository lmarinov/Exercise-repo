package aquarium;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AquariumTests {
    private Aquarium aquarium;
    private Fish fish;
    private static final String TEST_FISH_NAME = "test_fish_1";
    private static final int TEST_CAPACITY = 1;
    private static final String TEST_AQUARIUM_NAME = "test_1";

    @Before
    public void setUp(){
        this.aquarium = new Aquarium(TEST_AQUARIUM_NAME, TEST_CAPACITY);
        this.fish = new Fish(TEST_FISH_NAME);
    }

    @Test
    public void testGetNameShouldReturnAquariumName(){
        String actualName = aquarium.getName();

        assertEquals(TEST_AQUARIUM_NAME, actualName);
    }

    @Test(expected = NullPointerException.class)
    public void testAquariumInitializationShouldThrowExceptionWhenNameEmpty(){
        aquarium = new Aquarium("", TEST_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testAquariumInitializationShouldThrowExceptionWhenNameNull(){
        aquarium = new Aquarium(null, TEST_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAquariumInitializationShouldThrowExceptionWhenCapacityLessThanZero(){
        aquarium = new Aquarium(TEST_AQUARIUM_NAME, -1);
    }

    @Test
    public void testGetCapacityShouldReturnAquariumCapacity(){
        int actualCapacity = aquarium.getCapacity();

        assertEquals(TEST_CAPACITY, actualCapacity);
    }

    @Test
    public void testAddShouldAddFishToFishCollection(){
        aquarium.add(fish);
        List<Fish> fish = new ArrayList<>();
        fish.add(this.fish);

        assertEquals(fish.size(), aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowExceptionWhenCapacityReached(){
        aquarium.add(fish);
        aquarium.add(fish);
    }

    @Test
    public void testRemoveShouldRemoveFishByGivenName(){
        aquarium.add(fish);
        aquarium.remove(fish.getName());

        assertEquals(aquarium.getCount(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowExceptionWhenNoSuchFish(){
        aquarium.add(fish);
        aquarium.remove("Unknown_name");
    }

    @Test
    public void testSellFishShouldSellFishByGivenName(){
        aquarium.add(fish);
        Fish actualFish = aquarium.sellFish(fish.getName());
        Fish expectedFish = fish;

        assertEquals(aquarium.getCount(), 1);
        assertEquals(expectedFish, actualFish);
        assertFalse(actualFish.isAvailable());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishShouldThrowExceptionWhenNoSuchFish(){
        aquarium.add(fish);
        aquarium.sellFish("Unknown_name");
    }

    @Test
    public void testReportShouldGiveInfoAboutFishInTheAquarium(){
        aquarium = new Aquarium(TEST_AQUARIUM_NAME, 3);
        addFish();
        List<Fish> expectedFish = new ArrayList<>();
        expectedFish.add(new Fish("test_fish_2"));
        expectedFish.add(new Fish("test_fish_3"));
        expectedFish.add(new Fish("test_fish_4"));

        String actualOutput = aquarium.report();
        String expectedFishNames = expectedFish.stream().map(Fish::getName).collect(Collectors.joining(", "));
        String expectedOutput = String.format("Fish available at %s: %s", TEST_AQUARIUM_NAME, expectedFishNames);

        assertEquals(expectedOutput, actualOutput);
    }

    public void addFish(){
        aquarium.add(new Fish("test_fish_2"));
        aquarium.add(new Fish("test_fish_3"));
        aquarium.add(new Fish("test_fish_4"));
    }
}

