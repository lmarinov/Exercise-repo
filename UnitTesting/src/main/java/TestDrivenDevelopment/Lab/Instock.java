package TestDrivenDevelopment.Lab;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private Map<String, Product> products;

    public Instock(){
        this.products = new LinkedHashMap<>();
    }


    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.containsKey(product.getLabel());
    }

    @Override
    public void add(Product product) {
        if (!contains(product)){
            this.products.put(product.getLabel(), product);
        }
    }

    @Override
    public void changeQuantity(String label, int quantity) {
        if (!products.containsKey(label)){
            throw new IllegalArgumentException();
        }

        Product product = products.get(label);
        product.setQuantity(product.getQuantity() + quantity);
    }

    @Override
    public Product find(int index) {
        return new ArrayList<>(this.products.values()).get(index);
    }

    @Override
    public Product findByLabel(String label) {
        validateLabelExists(label);
        return products.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        return findFirstByComparator(count, Comparator.comparing(Product::getLabel), "alphabetical");
    }


    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.products.values()
                .stream()
                .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return findAllMatching(p -> p.getPrice() == price);
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        return findFirstByComparator(count, Comparator.comparingDouble(Product::getPrice).reversed(), "mostExpensive");
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return findAllMatching(p -> p.getQuantity() == quantity);
    }

    @Override
    public Iterator<Product> iterator() {
        return products.values().iterator();
    }

    private void validateLabelExists(String label) {
        if (!products.containsKey(label)){
            throw new IllegalArgumentException();
        }
    }

    private Iterable<Product> findFirstByComparator(int count, Comparator<Product> comparator, String comparisonType) {
        if (count <= 0 || count > this.getCount()){
            if (comparisonType.equals("alphabetical")){
                return new ArrayList<>();
            }else if (comparisonType.equals("mostExpensive")){
                throw new IllegalArgumentException();
            }
        }

        return products.values().stream()
                .sorted(comparator)
                .limit(count)
                .collect(Collectors.toList());
    }

    private Iterable<Product> findAllMatching(Predicate<Product> predicate){
            return products.values()
                    .stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
    }
}
