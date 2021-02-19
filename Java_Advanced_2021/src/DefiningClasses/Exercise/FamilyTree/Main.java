package DefiningClasses.Exercise.FamilyTree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Person> people = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String personInfo = scanner.nextLine();
        Person centerPerson = new Person(personInfo);
        List<Map<String, String>> pairs = new ArrayList<>();

        String relativesInfo = "";
        while (!"End".equals(relativesInfo = scanner.nextLine())) {
            String[] tokens = relativesInfo.split("\\s-\\s");

            if (tokens.length > 1) {
                Map<String, String> pair = new LinkedHashMap<>();
                pair.put(tokens[0], tokens[1]);
                pairs.add(pair);
            } else {
                tokens = relativesInfo.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String birthDate = tokens[2];

                Person person = new Person(name, birthDate);
                people.add(person);

                if (birthDate.equals(centerPerson.getBirthday()) && centerPerson.getName() == null){
                    centerPerson.setName(name);
                }else if(name.equals(centerPerson.getName()) && centerPerson.getBirthday() == null){
                    centerPerson.setBirthday(birthDate);
                }
            }
        }

        for (Map<String, String> pair : pairs) {
            for (Map.Entry<String, String> entry : pair.entrySet()) {
                if (entry.getKey().equals(centerPerson.getName()) || entry.getKey().equals(centerPerson.getBirthday())){
                    people.stream()
                            .filter(p -> p.getName().equals(entry.getValue()) || p.getBirthday().equals(entry.getValue()))
                            .findFirst()
                            .ifPresent(centerPerson::addChildren);
                }else if(entry.getValue().equals(centerPerson.getName()) || entry.getValue().equals(centerPerson.getBirthday())){
                    people.stream()
                            .filter(p -> p.getName().equals(entry.getKey()) || p.getBirthday().equals(entry.getKey()))
                            .findFirst()
                            .ifPresent(centerPerson::addParents);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(centerPerson)
                .append(System.lineSeparator())
                .append("Parents:")
                .append(System.lineSeparator())
                .append(centerPerson.getParents().size() == 0 ? "" : String.format("%s%s", centerPerson.getParents()
                        .stream()
                        .map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())), System.lineSeparator()))
                .append("Children:")
                .append(System.lineSeparator())
                .append(String.format("%s", centerPerson.getChildren()
                        .stream()
                        .map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator()))));

        System.out.println(sb);
    }

}
