package WorkingWithAbstraction.Exercise.CardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        System.out.println("Card Suits:");
        if (command.equals("Card Suits")){
            for (CardSuit value : CardSuit.values()) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.name());
            }
        }
    }
}
