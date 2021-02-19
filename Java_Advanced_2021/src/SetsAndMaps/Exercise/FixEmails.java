package SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = "";
        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!"stop".equals(line = scanner.nextLine())){
            String email = scanner.nextLine();

            if (email.substring(email.length() - 3).toLowerCase().matches("\\.bg")){
                phonebook.put(line, email);
            }
        }

        phonebook.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
