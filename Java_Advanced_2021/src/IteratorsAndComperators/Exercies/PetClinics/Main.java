package IteratorsAndComperators.Exercies.PetClinics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        for (int i = 0; i < commandsCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]){
                case "Create":
                    if (tokens[1].equals("Pet")){
                        String petName = tokens[2];
                        Pet pet = new Pet(petName,
                                Integer.parseInt(tokens[3]),
                                tokens[4]);
                        pets.putIfAbsent(petName, pet);
                    }else{
                        try {
                            String clinicName = tokens[2];
                            Clinic clinic = new Clinic(Integer.parseInt(tokens[3]));
                            clinics.putIfAbsent(clinicName, clinic);
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = tokens[1];
                    String clinicName = tokens[2];
                    Pet pet = pets.get(petName);
                    Clinic clinic = clinics.get(clinicName);

                    if (pet != null && clinic != null){
                        System.out.println(clinic.addPet(pet));
                    }else{
                        System.out.println("Invalid Operation!");
                    }

                    break;
                case "Release":
                    Clinic c = clinics.get(tokens[1]);
                    if (c != null){
                        System.out.println(c.release());
                    }else{
                        System.out.println("Invalid Operation!");
                    }

                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(tokens[1]).hasEmptyRooms());
                    break;
                case "Print":
                    String cName = tokens[1];
                    Clinic cl = clinics.get(cName);
                    if (cl == null){
                        System.out.println("Invalid Operation!");
                        break;
                    }
                    if (tokens.length == 2){
                        for (Pet clPet : cl.getPets()) {
                            if (clPet == null){
                                System.out.println("Room empty");
                            }else{
                                System.out.println(clPet);
                            }
                        }
                    }else{
                        int room = Integer.parseInt(tokens[2]);
                        cl.print(room);
                    }
                    break;
            }
        }
    }
}
