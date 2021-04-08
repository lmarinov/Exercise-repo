package exercise.p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void whenUnsortedArrayPassedThenArrayMustBeSortedInAscendingOrder(){
        int[] array = new int[] {5, 14, -3, 0, 2034323, -23423423};
        Bubble.sort(array);
        int[] expectedArray = new int[] {-23423423, -3, 0, 5, 14, 2034323};
        assertArrayEquals(array, expectedArray);
    }

    @Test
    public void whenSortedArrayIsPassedToSortMethodThenArrayStaysUnmodified(){
        int[] array = new int[] {-23423423, -3, 0, 5, 14, 2034323};
        Bubble.sort(array);
        int[] expectedArray =  new int[] {-23423423, -3, 0, 5, 14, 2034323};
        assertArrayEquals(array, expectedArray);
    }

    @Test
    public void whenEmptyArrayPassedToSortMethodThenEmptyArrayIsReturned(){
        int[] array = new int[]{};
        Bubble.sort(array);
        assertEquals(array.length, 0);
    }
}