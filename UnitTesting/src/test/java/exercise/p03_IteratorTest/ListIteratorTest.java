package exercise.p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    @Before
    public void setUp(){

    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenNullElementIsPassedToConstructorThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void whenValidElementsArePassedToConstructorThenMoveShouldReturnCorrectBoolean() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("wood", "river", "gold");
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void whenPrintingEmptyListIteratorThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        new ListIterator().print();
    }

    @Test
    public void whenValidElementsArePassedToListIteratorThenTheyShouldBePrintable() throws OperationNotSupportedException {
        String[] elements = new String[]{"wood", "river", "gold"};
        ListIterator listIterator = new ListIterator(elements);
        for (int i = 0;listIterator.hasNext(); listIterator.move(), i++){
          assertEquals(elements[i], listIterator.print());
        }
    }

}