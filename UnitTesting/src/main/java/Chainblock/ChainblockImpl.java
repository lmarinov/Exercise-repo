package Chainblock;

import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{
    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return transactions.size();
    }

    public void add(Transaction transaction) {
        if (!this.contains(transaction)){
            this.transactions.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return this.transactions.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        getById(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!this.transactions.containsKey(id)){
            throw new IllegalArgumentException();
        }
        Transaction transactionToBeRemoved = this.transactions.get(id);
        this.transactions.remove(id, transactionToBeRemoved);
    }

    public Transaction getById(int id) {
        return this.transactions.values().stream().filter(e -> e.getId() == id).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        for(Map.Entry<Integer, Transaction> transactionEntry : this.transactions.entrySet()){
            boolean condition = transactionEntry.getValue().getStatus().compareTo(status) == 0;

            if (condition){
                transactions.add(transactionEntry.getValue());
            }
        }

        checkIfEmpty(transactions.size());

        return transactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> senders = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .map(transaction -> transaction.getSender())
                .collect(Collectors.toList());

        checkIfEmpty(senders.size());
        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> receivers = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .map(transaction -> transaction.getReceiver())
                .collect(Collectors.toList());

        checkIfEmpty(receivers.size());
        return receivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactions
                .values()
                .stream()
                .sorted(Comparator.comparingDouble(Transaction::getId).reversed())
                .sorted(Comparator.comparingInt(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactionsBySender = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getSender().equals(sender))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        checkIfEmpty(transactionsBySender.size());

        return transactionsBySender;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactionsByReceiver = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getReceiver().equals(receiver))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .sorted(Comparator.comparingInt(Transaction::getId))
                .collect(Collectors.toList());

        checkIfEmpty(transactionsByReceiver.size());

        return transactionsByReceiver;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status) && transaction.getAmount() <= amount)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactionsBySenderAndMin = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getSender().equals(sender) && transaction.getAmount() > amount)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        checkIfEmpty(transactionsBySenderAndMin.size());

        return transactionsBySenderAndMin;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactionsByReceiverAndAmountRange = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getReceiver().equals(receiver) && transaction.getAmount() <= hi && transaction.getAmount() >= lo)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .sorted(Comparator.comparingInt(Transaction::getId))
                .collect(Collectors.toList());

        checkIfEmpty(transactionsByReceiverAndAmountRange.size());

        return transactionsByReceiverAndAmountRange;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getAmount() <= hi && transaction.getAmount() >= lo)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return this.transactions.values().iterator();
    }

    private void checkIfEmpty(int size) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
    }
}
