package exercise.p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = new Person[]{
            new Person(1, "A"),
            new Person(2, "B"),
            new Person(3, "C"),
            new Person(4, "D")
    };

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void whenCorrectElementsArePassedDatabaseHasToBeCreated() throws OperationNotSupportedException {
        // Arrange
        // Act
        // Assert
        assertEquals(PEOPLE.length, database.getElements().length);
        assertArrayEquals(PEOPLE, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenElementsPassedThroughTheConstructorAreMoreThan16ThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        new Database(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenElementsPassedThroughTheConstructorAreLessThanOneExceptionShouldBeThrown() throws OperationNotSupportedException {
        new Database();
    }

    @Test
    public void whenAddMethodIsCalledWithValidElementThenItShouldBeAddedAtLastPlaceInTheCollection() throws OperationNotSupportedException {
        Person expectedPerson = new Person(4, "D");
        database.add(expectedPerson);
        Person[] databaseElements = database.getElements();
        assertEquals(PEOPLE.length + 1, databaseElements.length);
        Person actualPerson = databaseElements[databaseElements.length - 1];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenInvalidElementPassedToAddThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void whenRemoveMethodIsCalledWithValidElementTHenItShouldBeRemoved() throws OperationNotSupportedException {
        database.remove();
        Person[] databaseElements = database.getElements();
        assertEquals(PEOPLE.length - 1, databaseElements.length);
        Person expectedPerson =  PEOPLE[PEOPLE.length - 2];
        Person actualPerson =  databaseElements[databaseElements.length - 1];
        assertEquals(actualPerson.getId(), expectedPerson.getId());
        assertEquals(actualPerson.getUsername(), expectedPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenRemoveCalledOnEmptyCollectionThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        database = new Database(new Person(5, "E"));
        database.remove();
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenNullPassedToFindByUsernameForUsernameThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void whenValidUsernameIsPassedToFindByUsernameThenReturnPerson() throws OperationNotSupportedException {
        Person actualPerson = database.findByUsername("B");
        Person expectedPerson = PEOPLE[1];
        assertEquals(actualPerson.getId(), expectedPerson.getId());
        assertEquals(actualPerson.getUsername(), expectedPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenEmptyCollectionIsPassedToFindByUsernameThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.remove();
        database.findByUsername("A");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenFindPersonByIdIsPassedOnEmptyArrayThenExceptionShouldBeThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.remove();
        database.findById(1);
        database.findById(2);
        database.findById(3);
        database.findById(4);
    }

    @Test
    public void whenValidIdPassedToFindPersonByIdThenPersonShouldBeReturned() throws OperationNotSupportedException {
        Person actualPerson = database.findById(2);
        Person expectedPerson = PEOPLE[1];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }
}