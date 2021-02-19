package DefiningClasses.Exercise.CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = "";
        List<Cat> cats = new ArrayList<>();

        while (!"End".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\s+");

            switch (tokens[0]){
                case "Siamese":
                    cats.add(new SiameseCat(tokens[1], Double.parseDouble(tokens[2])));
                    break;
                case "Cymric":
                    cats.add(new CymricCat(tokens[1], Double.parseDouble(tokens[2])));
                    break;
                case "StreetExtraordinaire":
                    cats.add(new StreetExtraordinaire(tokens[1], Double.parseDouble(tokens[2])));
                    break;
            }
        }

        String searchedCat = scanner.nextLine();

        cats.stream().filter(e -> e.getName().equals(searchedCat))
                .forEach(System.out::println);
    }
}
