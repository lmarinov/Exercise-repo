package NestedLoops.Lab;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int multiplicand = 1; multiplicand <= 10; multiplicand++){
            for (int multiplier = 1; multiplier <= 10; multiplier++){
                int product = multiplicand * multiplier;
                System.out.printf("%d * %d = %d%n", multiplicand, multiplier, product);
            }
        }
    }
}
