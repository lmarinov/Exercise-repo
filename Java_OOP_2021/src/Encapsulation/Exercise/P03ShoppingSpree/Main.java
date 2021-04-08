package Encapsulation.Exercise.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = "";
        List<Person> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        boolean noException = true;


        for (int i = 0; i < 2; i++) {
            String[] items = scanner.nextLine().split(";");
            if (i == 0) {
                for (String item : items) {
                    String[] tokens = item.split("=");
                    String name = tokens[0];
                    int money = Integer.parseInt(tokens[1]);

                    try {
                        Person currentPerson = new Person(name, money);
                        customers.add(currentPerson);
                    } catch (IllegalStateException e) {
                        noException = false;
                        System.out.println(e.getMessage());
                        break;
                    }
                }
            } else {
                for (String item : items) {
                    String[] tokens = item.split("=");
                    String name = tokens[0];
                    double cost = Double.parseDouble(tokens[1]);

                    try {
                        Product currentProduct = new Product(name, cost);
                        products.add(currentProduct);
                    } catch (IllegalStateException e) {
                        noException = false;
                        System.out.println(e.getMessage());
                        break;
                    }
                }
            }
        }
        if (noException) {
            while (!"END".equals(command = scanner.nextLine())) {
                String[] tokens = command.split("\\s+");
                String customerName = tokens[0];
                String productName = tokens[1];

                for (Person customer : customers) {
                    if (customer.getName().equals(customerName)) {
                        for (Product product : products) {
                            if (product.getName().equals(productName)) {
                                try {
                                    customer.buyProduct(product);
                                }catch (IllegalStateException e){
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }
                }
            }

            for (Person customer : customers) {
                System.out.printf("%s - %s%n",
                        customer.getName(),
                        customer.getProducts().size() > 0 ? customer.getProducts().stream()
                                .map(Product::getName)
                                .collect(Collectors.joining(", "))
                        : "Nothing bought");
            }
        }
    }
}
