package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {

    private BankVault bankVault;
    private Map<String, Item> testVaultCells;
    private Item testItem;

    @Before
    public void setUp() {
        this.bankVault = new BankVault();
        this.testVaultCells = new LinkedHashMap<>();
        this.testVaultCells.put("A1", null);
        this.testVaultCells.put("A2", null);
        this.testVaultCells.put("A3", null);
        this.testVaultCells.put("A4", null);
        this.testVaultCells.put("B1", null);
        this.testVaultCells.put("B2", null);
        this.testVaultCells.put("B3", null);
        this.testVaultCells.put("B4", null);
        this.testVaultCells.put("C1", null);
        this.testVaultCells.put("C2", null);
        this.testVaultCells.put("C3", null);
        this.testVaultCells.put("C4", null);
        testItem = new Item("Tosho", "12312");
    }

    @Test
    public void testGetVaultCellsShouldReturnCells() {
        Map<String, Item> vaultCells = Collections.unmodifiableMap(this.bankVault.getVaultCells());

        assertEquals(vaultCells, testVaultCells);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemsShouldThrowExceptionWhenNoSuchCell() throws OperationNotSupportedException {
        this.bankVault.addItem("H32", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemsShouldThrowExceptionWhenCellIsNotEmpty() throws OperationNotSupportedException {
        this.bankVault.addItem("A1", testItem);
        this.bankVault.addItem("A1", new Item("Gero", "123"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemsShouldThrowExceptionWhenSameItemIsAddedTwice() throws OperationNotSupportedException {
        this.bankVault.addItem("A1", testItem);
        this.bankVault.addItem("A2", testItem);
    }

    @Test
    public void testAddItemsShouldAddTheItemCorrectlyAndDisplayCorrectMessage() throws OperationNotSupportedException {
        String actualMessage = this.bankVault.addItem("A1", testItem);
        String expectedMessage = "Item:12312 saved successfully!";
        this.testVaultCells.put("A1", testItem);
        Item expectedItem = this.testVaultCells.get("A1");
        Item actualItem = this.bankVault.getVaultCells().get("A1");


        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedItem, actualItem);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemsShouldThrowExceptionWhenNoSuchCell(){
        this.bankVault.removeItem("H32", testItem);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemsShouldThrowExceptionWhenItemDoesNotExistInCell(){
        this.bankVault.removeItem("A1", testItem);
    }

    @Test
    public void testRemoveItemsShouldReturnCorrectMessageAndShouldPutValueInCellToNull() throws OperationNotSupportedException {
        this.bankVault.addItem("A1", testItem);

        String actualMessage = this.bankVault.removeItem("A1", testItem);
        String expectedMessage = "Remove item:12312 successfully!";
        Item expectedItem = this.testVaultCells.get("A1");
        Item actualItem = this.bankVault.getVaultCells().get("A1");

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedItem, actualItem);
    }

}