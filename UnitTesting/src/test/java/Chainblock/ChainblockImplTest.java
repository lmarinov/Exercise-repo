package Chainblock;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private Transaction transaction;
    private Chainblock chainblock;
    private static final int AMOUNT = 5;
    private static final TransactionStatus STATUS = TransactionStatus.FAILED;
    private static final String SENDER = "Pesho";
    private static final String RECEIVER = "Gosho";
    private static final double LOW = 0.45;
    private static final double HIGH = 100.74;

    @Before
    public void setUp() {
        transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 5);
        chainblock = new ChainblockImpl();
    }

    @Test
    public void testAddTransactionShouldAddATransactionToTheRecord() {
        chainblock.add(transaction);
        int actualSize = chainblock.getCount();
        int expectedSize = 1;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testAddTransactionShouldAddAUniqueTransaction() {
        chainblock.add(transaction);
        chainblock.add(transaction);

        int actualSize = chainblock.getCount();
        int expectedSize = 1;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testContainsIDShouldCheckIfIDIsContainedInTransactions() {
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 5);
        chainblock.add(transaction);
        chainblock.add(transaction2);

        assertTrue(chainblock.contains(1));
        assertTrue(chainblock.contains(2));
        assertFalse(chainblock.contains(3));
    }

    @Test
    public void testContainsMethodShouldReturnTrueForExistingAndFalseForNonExistingTransaction() {
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 5);
        chainblock.add(transaction);

        assertTrue(chainblock.contains(transaction));
        assertFalse(chainblock.contains(transaction2));
    }

    @Test
    public void testChangeTransactionStatusShouldAlterTheTransactionStatusOfExistingTransaction() {
        chainblock.add(transaction);
        TransactionStatus expectedTransactionStatus = TransactionStatus.FAILED;
        chainblock.changeTransactionStatus(1, expectedTransactionStatus);

        assertEquals(expectedTransactionStatus, chainblock.getById(1).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusShouldThrowExceptionIfNoSuchTransaction() {
        chainblock.add(transaction);
        chainblock.changeTransactionStatus(2, TransactionStatus.ABORTED);
    }

    @Test
    public void testRemoveTransactionByValidIdShouldDecreaseTheSizeOfTheChainblock() {
        generateTransactions();
        chainblock.removeTransactionById(2);
        int expectedTransactions = 8;
        int actual = this.chainblock.getCount();

        assertEquals(expectedTransactions, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByValidIdShouldThrowAnExceptionIfNoSuchId() {
        generateTransactions();
        chainblock.removeTransactionById(30);
    }

    @Test
    public void testGetByValidIDShouldReturnCorrectTransaction() {
        this.chainblock.add(this.transaction);
        Transaction expected = this.transaction;
        Transaction actual = chainblock.getById(transaction.getId());

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByValidIdShouldThrowAnExceptionIfInvalid() {
        chainblock.getById(2);
    }

    @Test
    public void testGetByTransactionTypeShouldReturnListOfTransactionWithTheGivenStatus() {
        generateTransactions();
        Iterable<Transaction> transactions = this.chainblock.getByTransactionStatus(TransactionStatus.FAILED);
        List<Transaction> expectedTransactions = new ArrayList<>();
        iterateThroughTransactionsAndFilterByTransactionStatus(expectedTransactions);

        assertEquals(expectedTransactions, transactions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionTypeShouldThrowExceptionIfNoTransactionWithGivenStatus() {
        Iterable<Transaction> transactions = this.chainblock.getByTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusShouldReturnCorrectSenders() {
        generateTransactions();
        Iterable<String> actual = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
        List<Transaction> sorted = new ArrayList<>();
        iterateThroughTransactionsAndFilterByTransactionStatus(sorted);

        List<String> expected = sorted
                .stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .map(Transaction::getSender)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusShouldThrowExceptionWhenNoTransactionsExist() {
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusShouldReturnCorrectSenders() {
        generateTransactions();
        Iterable<String> actual = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
        List<Transaction> sorted = new ArrayList<>();
        iterateThroughTransactionsAndFilterByTransactionStatus(sorted);

        List<String> expected = sorted
                .stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .map(Transaction::getReceiver)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusShouldThrowExceptionWhenNoTransactionsExist() {
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdShouldReturnTransactionsOrderedByAmountDescendingAndThenById() {
        generateTransactions();
        List<Transaction> actual = (List<Transaction>) this.chainblock.getAllOrderedByAmountDescendingThenById();
        List<Transaction> expected = new ArrayList<Transaction>();
        iterateThroughTransactionsAndAddAll(expected);
        expected = expected
                .stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .sorted(Comparator.comparingInt(Transaction::getId))
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingShouldReturnTransactionsWithSpecificSenderAndReturnThemOrderedByAmountDescending(){
        generateTransactions();
        List<Transaction> actual = (List<Transaction>) this.chainblock.getBySenderOrderedByAmountDescending(SENDER);
        List<Transaction> expected = new ArrayList<Transaction>();
        iterateThroughTransactionsAndAddAll(expected);
        expected = expected
                .stream()
                .filter(t -> t.getSender().equals(SENDER))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingShouldThrowExceptionWhenThereAreNoTransactions(){
        this.chainblock.getBySenderOrderedByAmountDescending("Pesho");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdShouldReturnTransactionsToTheGivenReceiverOrderedByAmountDescendingAndThenById() {
        generateTransactions();
        List<Transaction> actual = (List<Transaction>) this.chainblock.getByReceiverOrderedByAmountThenById(RECEIVER);
        List<Transaction> expected = new ArrayList<Transaction>();
        iterateThroughTransactionsAndAddAll(expected);
        expected = expected
                .stream()
                .filter(e -> e.getReceiver().equals(RECEIVER))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .sorted(Comparator.comparingInt(Transaction::getId))
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdShouldThrowExceptionWhenNoSuchTransactions() {
        generateTransactions();
        String receiver = "Traicho"; // Non-existent receiver.
        List<Transaction> actual = (List<Transaction>) this.chainblock.getByReceiverOrderedByAmountThenById(receiver);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnAllTransactionsWithGivenStatusAndAmountLessThanOrEqualToAGivenMaximumOrderedByAmountDescending(){
        generateTransactions();
        List<Transaction> actual = (List<Transaction>) this.chainblock.getByTransactionStatusAndMaximumAmount(STATUS, AMOUNT);
        List<Transaction> expected = new ArrayList<Transaction>();
        iterateThroughTransactionsAndAddAll(expected);
        expected = expected
                .stream()
                .filter(e -> e.getStatus().equals(STATUS) && e.getAmount() <= AMOUNT)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionWhenNoSuchTransactionIsFound(){
        List<Transaction> actual = (List<Transaction>) this.chainblock.getByTransactionStatusAndMaximumAmount(STATUS, AMOUNT);
        List<Transaction> expected = new ArrayList<Transaction>();
        iterateThroughTransactionsAndAddAll(expected);
        expected = expected
                .stream()
                .filter(e -> e.getStatus().equals(STATUS) && e.getAmount() <= AMOUNT)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescendingShouldReturnAllTransactionsWithGivenSenderAndAmountBiggerThanGivenAmountOrderedByAmountDescending(){
        generateTransactions();
        List<Transaction> actual = (List<Transaction>) this.chainblock.getBySenderAndMinimumAmountDescending(SENDER, AMOUNT);
        List<Transaction> expected = new ArrayList<Transaction>();
        iterateThroughTransactionsAndAddAll(expected);
        expected = expected
                .stream()
                .filter(e -> e.getSender().equals(SENDER) && e.getAmount() > AMOUNT)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingShouldThrowExceptionWhenNoSuchTransactions(){
        List<Transaction> actual = (List<Transaction>) this.chainblock.getBySenderAndMinimumAmountDescending(SENDER, AMOUNT);
    }

    @Test
    public void testGetByReceiverAndAmountRangeShouldReturnAllTransactionsWithGivenReceiverAndAmountBetweenLowAndHighOrderedByAmountDescending(){
        generateTransactions();
        List<Transaction> actual = (List<Transaction>) this.chainblock.getByReceiverAndAmountRange(RECEIVER, LOW, HIGH);
        List<Transaction> expected = new ArrayList<Transaction>();
        iterateThroughTransactionsAndAddAll(expected);
        expected = expected
                .stream()
                .filter(e -> e.getReceiver().equals(RECEIVER) && e.getAmount() >= LOW && e.getAmount() <= HIGH)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .sorted(Comparator.comparingInt(Transaction::getId))
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrowExceptionIfNoSuchTransactions(){
        List<Transaction> actual = (List<Transaction>) this.chainblock.getByReceiverAndAmountRange(RECEIVER, LOW, HIGH);
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnAllTransactionsWithinRangeByInsertionOrder(){
        generateTransactions();
        List<Transaction> actual = (List<Transaction>) this.chainblock.getAllInAmountRange(LOW, HIGH);
        List<Transaction> expected = new ArrayList<Transaction>();
        iterateThroughTransactionsAndAddAll(expected);
        expected = expected
                .stream()
                .filter(e -> e.getAmount() >= LOW && e.getAmount() <= HIGH)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnEmptyCollectionWhenNoSuchTransactionsFound(){
        List<Transaction> actual = (List<Transaction>) this.chainblock.getAllInAmountRange(LOW, HIGH);
        List<Transaction> expected = new ArrayList<Transaction>();
        assertEquals(expected, actual);
        generateTransactions();
        double incorrectLo = 1000.35;
        double incorrectHigh = 10000.47;
        actual = (List<Transaction>) this.chainblock.getAllInAmountRange(incorrectLo, incorrectHigh);
        iterateThroughTransactionsAndAddAll(expected);
        expected = expected
                .stream()
                .filter(e -> e.getAmount() >= incorrectLo && e.getAmount() <= incorrectHigh)
                .collect(Collectors.toList());

        assertEquals(expected, actual);

    }



    private void generateTransactions() {
        for (int i = 2; i <= 10; i++) {
            this.chainblock.add(new TransactionImpl(i, TransactionStatus.FAILED, "Pesho", "Gosho", i));
        }
    }

    private void iterateThroughTransactionsAndFilterByTransactionStatus(List<Transaction> expectedTransactions) {
        Iterator<Transaction> iterator = this.chainblock.iterator();

        while (iterator.hasNext()) {
            Transaction current = iterator.next();
            if (current != null && current.getStatus().equals(TransactionStatus.FAILED)) {
                expectedTransactions.add(current);
            }
        }
    }

    private void iterateThroughTransactionsAndAddAll(List<Transaction> expectedTransactions) {
        Iterator<Transaction> iterator = this.chainblock.iterator();

        while (iterator.hasNext()) {
            Transaction current = iterator.next();
            if (current != null) {
                expectedTransactions.add(current);
            }
        }
    }
}