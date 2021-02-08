package DefiningClasses.Exercise.CompanyRoster;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = null;
            departments.putIfAbsent(department, new Department(department));

            if(tokens.length == 6){
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position,department, email, age);
            }else if(tokens.length == 4){
                employee = new Employee(name, salary, position,department);
            }else if(tokens.length == 5){
                if (tokens[4].matches("^\\d+$")){
                    int age = Integer.parseInt(tokens[4]);employee = new Employee(name, salary, position,department, age);

                }else{
                    String email = tokens[4];
                    employee = new Employee(name, salary, position,department, email);
                }
            }
            departments.get(department).addEmployee(employee);
        }

        double bestAverageSalary = Integer.MIN_VALUE;
        String bestDepartment = "";
        for (Map.Entry<String, Department> department : departments.entrySet()) {
            if (bestAverageSalary < department.getValue().getAverageSalary()){
                bestAverageSalary = department.getValue().getAverageSalary();
                bestDepartment = department.getKey();
            }
        }

        Department department = departments.get(bestDepartment);
        System.out.println(String.format("Highest Average Salary: %s", bestDepartment));
        department.getEmployeeList()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
