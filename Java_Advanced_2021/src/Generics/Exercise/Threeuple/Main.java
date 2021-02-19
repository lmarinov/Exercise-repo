package Generics.Exercise.Threeuple;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Threeuple> threeuples = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Threeuple threeuple;
            if (i == 0){
                String name = tokens[0] + " " +  tokens[1];
                String address = tokens[2];
                String town = tokens[3];
                threeuple = new Threeuple<>(name, address, town);
            }else if(i == 1){
                String name = tokens[0];
                int litersOfBeer = Integer.parseInt(tokens[1]);
                boolean isDrunk = tokens[2].equals("drunk");
                threeuple = new Threeuple<>(name, litersOfBeer, isDrunk);
            }else{
                String name = tokens[0];
                Double accountBalance = Double.parseDouble(tokens[1]);
                String bankName = tokens[2];
                threeuple = new Threeuple<>(name, accountBalance, bankName);

            }

            threeuples.add(threeuple);
        }

        threeuples.forEach(System.out::println);
    }
}
