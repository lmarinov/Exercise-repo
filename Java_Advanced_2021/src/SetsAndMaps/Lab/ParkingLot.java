package SetsAndMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();
        String input;

        while (!"END". equals(input = scanner.nextLine())){

            String registration = input.substring(input.indexOf(", ") + 2);

            if (input.contains("IN")){
                parking.add(registration);
            }else{
                parking.remove(registration);
            }
        }

        String output;

        if(!parking.isEmpty()){
            output = parking.stream().collect(Collectors.joining("\n"));
        }else{
            output = "Parking Lot is Empty";
        }

        System.out.println(output);

    }
}
