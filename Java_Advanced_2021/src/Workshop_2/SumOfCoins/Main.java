package Workshop_2.SumOfCoins;

import java.util.*;

public class Main {
    private static int totalCoins = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] coins = Arrays.stream(scanner.nextLine().substring(7).split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetSum = Integer.parseInt(scanner.nextLine().substring(5));

        try {
            Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
            System.out.printf("Number of coins to take: %d%n", totalCoins);
            usedCoins.entrySet().forEach(entry -> System.out.printf("%d coin(s) with value %d%n", entry.getValue(), entry.getKey()));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        List<Integer> sortedCoins = new LinkedList<>();
        Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).forEach(sortedCoins::add);
        Map<Integer, Integer> chosenCoins = new LinkedHashMap<>();
        int currentSum = 0;
        int coinIndex = 0;

        while (currentSum != targetSum && coinIndex < sortedCoins.size()){
            int currentCoin = sortedCoins.get(coinIndex);
            int moneyLeft = targetSum - currentSum;
            int numberOfCoins = moneyLeft / currentCoin;

            if (currentSum + currentCoin <= targetSum){
                chosenCoins.put(currentCoin, numberOfCoins);
                totalCoins += numberOfCoins;
                currentSum += currentCoin * numberOfCoins;
            }

            coinIndex++;
        }

        if (currentSum != targetSum){
            throw new IllegalArgumentException("Error");
        }

        return chosenCoins;
    }

}
