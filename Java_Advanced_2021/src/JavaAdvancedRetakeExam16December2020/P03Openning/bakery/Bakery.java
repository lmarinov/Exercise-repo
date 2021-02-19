package JavaAdvancedRetakeExam16December2020.P03Openning.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Employee employee){
        if (this.capacity > 0){
            this.employees.add(employee);
            capacity--;
        }
    }

    public boolean remove(String name){
        int index = -1;
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                index = this.getEmployees().indexOf(employee);
            }
        }

        if (index > -1){
            this.getEmployees().remove(index);
            capacity++;
            return true;
        }

        return false;
    }

    public Employee getOldestEmployee(){
        return employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name){
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        return String.format("Employees working at Bakery %s:%n%s",
                this.getName(),
                this.getEmployees().stream().map(Employee::toString).collect(Collectors.joining(System.lineSeparator())));
    }
}
