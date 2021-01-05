package NestedLoops.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        boolean isMagic = true;
        List<Integer> magicNumbers = new ArrayList<>();
//        Typetester t = new Typetester();
//        int number = Integer.parseInt(scanner.nextLine());
//        if (t.printType(number).equals("int")) System.out.println("yey");

        for (int i = 1111; i <= 9999; i++){
            for (int j = i; j > 0; j /= 10){
                int divisor = j % 10;
                if (divisor == 0) { isMagic = false; continue; }
                if (number % divisor != 0) isMagic = false;
            }

            if(isMagic) magicNumbers.add(i);
            isMagic = true;
        }

        magicNumbers.stream().map(s -> s + " ").forEach(System.out::print);
    }
}

//class Typetester {
//    public String printType (String x){
//        return "String";
//    }
//
//    public String printType (byte x){
//        return "byte";
//    }
//
//    public String printType (float x){
//        return "float";
//    }
//
//    public String printType (double x){
//        return "double";
//    }
//
//    public String printType (char x){
//        return "char";
//    }
//
//    public String printType (int x){
//        return "int";
//    }
//}


