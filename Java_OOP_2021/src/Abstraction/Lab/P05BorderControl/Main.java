package Abstraction.Lab.P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = "";
        List<Identifiable> inhabitants = new ArrayList<>();

        while (!"End".equals(command = scanner.nextLine())){
            String[] tokens = command.split("\\s+");
            if (tokens.length > 2){
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                inhabitants.add(new Citizen(name, age, id));
            }else{
                String model = tokens[0];
                String id = tokens[1];
                inhabitants.add(new Robot(model, id));
            }
        }

        String suspectID = scanner.nextLine();

        for (Identifiable inhabitant : inhabitants) {
            String id = inhabitant.getId();
            if (id.endsWith(suspectID)){
                System.out.println(id);
            }
        }
    }
}
