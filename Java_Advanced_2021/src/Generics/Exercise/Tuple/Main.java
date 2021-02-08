package Generics.Exercise.Tuple;

import java.util.Scanner;

public class Main <E>{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 3;
        while (count-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            printTuple(tokens, count);
        }
    }

    private static void printTuple(String[] tokens, int count){
        String name;
       if(count == 1){
            name = tokens[0];
            int liters = Integer.parseInt(tokens[1]);
            Tuple<String, Integer> personBeer = new Tuple<>(name, liters);
            print(personBeer);
        }else if(count == 0){
            int intNum = Integer.parseInt(tokens[0]);
            double floatNum = Double.parseDouble(tokens[1]);
            Tuple<Integer, Double> numbers = new Tuple<>(intNum, floatNum);
            print(numbers);
        }else {
            name = String.format("%s %s", tokens[0], tokens[1]);
            String address = tokens[2];
            Tuple<String, String> tuple = new Tuple<>(name, address);
            print(tuple);
        }
    }

    private static <E> void print(E input){
        System.out.println(input);
    }
}
