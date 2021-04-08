package exercise.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private static final Integer[] ELEMENTS = {4, 6, 2, 3, 13, 42};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(ELEMENTS);
    }

    @Test
    public void whenCorrectElementsArePassedDatabaseHasToBeCreated() throws OperationNotSupportedException {
        // Arrange
        // Act
        // Assert
        Assert.assertEquals(ELEMENTS.length, database.getElements().length);
        Assert.assertArrayEquals(ELEMENTS, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenElementsPassedThroughTheConstructorAreMoreThan16ThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenElementsPassedThroughTheConstructorAreLessThanOneExceptionShouldBeThrown() throws OperationNotSupportedException {
        new Database();
    }

    @Test
    public void whenAddMethodIsCalledWithValidElementThenItShouldBeAddedAtLastPlaceInTheCollection() throws OperationNotSupportedException {
        int element = 15;
        database.add(element);
        Integer[] databaseElements = database.getElements();
        Assert.assertEquals(ELEMENTS.length + 1, databaseElements.length);
        Assert.assertEquals(Integer.valueOf(element), databaseElements[databaseElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenInvalidElementPassedToAddThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void whenRemoveMethodIsCalledWithValidElementTHenItShouldBeRemoved() throws OperationNotSupportedException {
        database.remove();
        Integer[] databaseElements = database.getElements();
        assertEquals(ELEMENTS.length - 1, databaseElements.length);
        assertEquals(ELEMENTS[ELEMENTS.length - 2], databaseElements[databaseElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenRemoveCalledOnEmptyCollectionThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        database = new Database(new Integer[1]);
        database.remove();
        database.remove();
    }
}