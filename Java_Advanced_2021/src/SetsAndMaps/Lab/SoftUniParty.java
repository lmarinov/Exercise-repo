package SetsAndMaps.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String guestName;
        while (!"party".equalsIgnoreCase(guestName = scanner.next())){
            if (Character.isDigit(guestName.charAt(0))) vip.add(guestName);
            else regular.add(guestName);
        }

        while (!"end".equalsIgnoreCase(guestName = scanner.next())){
            if (Character.isDigit(guestName.charAt(0))) vip.remove(guestName);
            else regular.remove(guestName);
        }

        System.out.println(vip.size() + regular.size());
        vip.addAll(regular);
        vip.forEach(System.out::println);

    }
}
