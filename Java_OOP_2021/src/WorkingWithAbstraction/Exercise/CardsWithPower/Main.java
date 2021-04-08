package WorkingWithAbstraction.Exercise.CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = reader.readLine();
        String secondLine = reader.readLine();

        Card myCard = new Card(CardRank.valueOf(CardRank.class, firstLine), CardSuit.valueOf(CardSuit.class, secondLine));

        System.out.println(myCard);

    }
}
