package WorkingWithAbstraction.Exercise.GreedyTimes;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private long capacity;
//    private Item[] items;
    private long currentQuantityOfItems;
    private long gold;
    private boolean goldIsAdded;
    private Map<String, Long> gems;
    private Map<String, Long> cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.gems = new LinkedHashMap<String, Long>();
        this.cash = new LinkedHashMap<String, Long>();
        this.goldIsAdded = false;
        this.currentQuantityOfItems = 0;
    }

    public void addCash(String item, long quantity) {
        if (hasFreeCapacity(quantity) && getTotalCash() + quantity <= getTotalGems()){
            this.cash.putIfAbsent(item, 0L);
            this.cash.put(item, this.cash.get(item) + quantity);
            this.currentQuantityOfItems += quantity;
        }
    }

    public void addGems(String item, long quantity) {
        if (hasFreeCapacity(quantity) && getTotalGems() + quantity <= this.gold){
            this.gems.putIfAbsent(item, 0L);
            this.gems.put(item, this.gems.get(item) + quantity);
            this.currentQuantityOfItems += quantity;
        }
    }

    private long getTotalGems(){
        return this.gems.values().stream().mapToLong(e -> e).sum();
    }

    private long getTotalCash(){
        return this.cash.values().stream().mapToLong(e -> e).sum();
    }

    public void addGold(long quantity) {
        if(hasFreeCapacity(quantity)){
            this.goldIsAdded = true;
            this.gold += quantity;
            this.currentQuantityOfItems += quantity;
        }
    }

    private boolean hasFreeCapacity(long quantity){
        return this.currentQuantityOfItems + quantity <= this.capacity;
    }

    public void printContent(){
        StringBuilder sb = new StringBuilder();

        if (this.goldIsAdded){
            sb.append(String.format("<Gold> $%d", this.gold))
                    .append(System.lineSeparator())
                    .append(String.format("##Gold - %d",this.gold))
                    .append(System.lineSeparator());
        }

        if (!this.gems.isEmpty()){
            sb.append(String.format("<Gem> $%d", getTotalGems()))
                    .append(System.lineSeparator());
            this.gems.entrySet().stream().sorted(getComparator()).forEach(e -> {
                sb.append(String.format("##%s - %d", e.getKey(), e.getValue()))
                        .append(System.lineSeparator());
            });
        }

        if (!this.cash.isEmpty()){
            sb.append(String.format("<Cash> $%d", getTotalCash()))
                    .append(System.lineSeparator());
            this.cash.entrySet().stream().sorted(getComparator()).forEach(e -> {
                sb.append(String.format("##%s - %d", e.getKey(), e.getValue()))
                        .append(System.lineSeparator());
            });
        }

        System.out.println(sb.toString().trim());
    }

    private Comparator<Map.Entry<String, Long>> getComparator(){
        return (e1, e2) -> {
            int res = e2.getKey().compareTo(e1.getKey());
            if (res == 0){
                res = e1.getValue().compareTo(e2.getValue());
            }
            return res;
        };
    }
}
