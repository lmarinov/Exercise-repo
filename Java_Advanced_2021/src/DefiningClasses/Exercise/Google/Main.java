package DefiningClasses.Exercise.Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = "";
        Map<String, Person> people = new LinkedHashMap<>();

        while (!"End".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\s+");
            String personName = tokens[0];
            String indentifier = tokens[1];
            people.putIfAbsent(personName, new Person(personName));
            Person person = people.get(personName);

            switch (indentifier){
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    person.setCompany(new Person.Company(companyName, department, salary));
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    person.setCar(new Person.Car(carModel, carSpeed));
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    // in case we need to check if pokemon is unique
//                    if (person.getPokemonList().stream().noneMatch(pokemon -> pokemon.getPokemonName().equals(pokemonName)))

                    person.getPokemonList().add(new Person.Pokemon(pokemonName, pokemonType));
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    person.getParents().add(new Person.Parent(parentName, parentBirthday));
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    person.getChildren().add(new Person.Child(childName, childBirthday));
                    break;
            }
        }

        String searchedName = scanner.nextLine();
        Person searchedPerson = people.get(searchedName);

        System.out.println(searchedName);
        System.out.println("Company:");
        if (searchedPerson.getCompany() != null){
            System.out.printf("%s %s %.2f%n"
                    , searchedPerson.getCompany().getCompanyName()
                    , searchedPerson.getCompany().getDepartment()
                    , searchedPerson.getCompany().getSalary());
        }
        System.out.println("Car:");
        if (searchedPerson.getCar() != null){
            System.out.printf("%s %d%n"
                    , searchedPerson.getCar().getCarModel()
                    , searchedPerson.getCar().getCarSpeed());
        }
        System.out.println("Pokemon:");
        if (searchedPerson.getPokemonList().size() > 0){
            System.out.printf("%s%n"
                    , searchedPerson.getPokemonList()
                            .stream()
                            .map(pokemon -> String.join(" ", pokemon.getPokemonName(), pokemon.getPokemonType()))
                            .collect(Collectors.joining(System.lineSeparator())));
        }
        System.out.println("Parents:");
        if (searchedPerson.getParents().size() > 0){
            System.out.printf("%s%n"
                    , searchedPerson.getParents()
                            .stream()
                            .map(parent -> String.join(" ", parent.getParentName(), parent.getParentBirthday()))
                            .collect(Collectors.joining(System.lineSeparator())));
        }
        System.out.println("Children:");
        if (searchedPerson.getParents().size() > 0){
            System.out.printf("%s%n"
                    , searchedPerson.getChildren()
                            .stream()
                            .map(child -> String.join(" ", child.getChildName(), child.getChildBirthday()))
                            .collect(Collectors.joining(System.lineSeparator())));
        }
    }
}
