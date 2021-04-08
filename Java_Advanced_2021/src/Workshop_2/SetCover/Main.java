package Workshop_2.SetCover;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> universe = Arrays.stream(scanner.nextLine().split(":\\s")[1]
                .split(",\\s"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<LinkedHashSet<Integer>> sets = new LinkedHashSet<>();

        int numberOfSets = Integer.parseInt(scanner.nextLine().split(":\\s+")[1]);

        for (int i = 0; i < numberOfSets; i++) {
            LinkedHashSet<Integer> currentSet = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            sets.add(currentSet);
        }

        List<LinkedHashSet<Integer>> chosenSets = chooseSets(sets, universe);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (LinkedHashSet<Integer> chosenSet : chosenSets) {
            sb.append("{ ")
                    .append(chosenSet.stream().map(String::valueOf).collect(Collectors.joining(", ")))
                    .append(" }")
                    .append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static List<LinkedHashSet<Integer>> chooseSets(Set<LinkedHashSet<Integer>> sets, LinkedHashSet<Integer> universe) {
        List<LinkedHashSet<Integer>> selectedSets = new ArrayList<>();
        while (!universe.isEmpty()){
            int notChosenCount = 0;
            LinkedHashSet<Integer> chosenSet = new LinkedHashSet<>();
            for (LinkedHashSet<Integer> set : sets) {
                int count = 0;
                for (Integer elem : set) {
                    if (universe.contains(elem)){
                        count++;
                    }
                }

                if (notChosenCount < count){
                    notChosenCount = count;
                    chosenSet = set;
                }
            }

            selectedSets.add(chosenSet);
            for (Integer integer : chosenSet) {
                universe.remove(integer);
            }
        }
        return selectedSets;
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        HashSet<Integer> universeSet = Arrays.stream(universe).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        List<int[]> selectedSets = new ArrayList<>();
        while (!universeSet.isEmpty()){
            int notChosenCount = 0;
            int[] chosenSet = sets.get(0);
            for (int[] set : sets) {
                int count = 0;
                for (Integer elem : set) {
                    if (universeSet.contains(elem)){
                        count++;
                    }
                }

                if (notChosenCount < count){
                    notChosenCount = count;
                    chosenSet = set;
                }
            }

            selectedSets.add(chosenSet);
            for (Integer integer : chosenSet) {
                universeSet.remove(integer);
            }
        }
        return selectedSets;
    }
}
