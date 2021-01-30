package DefiningClasses.Lab.CarInfo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        List<Car> cars = new ArrayList<>();
//
//        while (n-- > 0){
//            Car car;
//            String[] input = scanner.nextLine().split("\\s+");
//            String brand = input[0];
//            if (input.length == 1){
//                car = new Car(brand);
//            }else{
//                String model  = input[1];
//                int horsePower = Integer.parseInt(input[2]);
//                car = new Car(brand, model, horsePower);
//            }
//            cars.add(car);
//        }
//
//        cars.forEach(e -> System.out.println(e.toString()));
        Map<Integer, BankAccount> vault = new HashMap<>();

        String input;
        String output = "";

        while (!"End".equals(input = scanner.nextLine())){
            String[] tokens = input.split("\\s+");

            switch (tokens[0]){
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if(!vault.containsKey(id)){
                        output = "Account does not exist";
                    }else{
                        vault.get(id).deposit(amount);
                        output = "Deposited "+ amount + " to ID" + id;
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(newInterest);
                    continue;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if(!vault.containsKey(id)){
                        output = "Account does not exist";
                    }else{
                        double interest = vault.get(id).getInterest(years);
                        output = String.format("%.2f", interest);
                    }
                    break;
                default:
                    BankAccount bankAccount = new BankAccount();
                    vault.put(bankAccount.getId(), bankAccount);
                    output = "Account ID" + bankAccount.getId() +  " created";
                    break;
            }

            System.out.println(output);
        }
    }
}
