package DefiningClasses.Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return Collections.unmodifiableList(employeeList);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee){
        this.employeeList.add(employee);
    }

    public double getAverageSalary(){
        return this.employeeList.stream().mapToDouble(Employee::getSalary).sum();
    }
}
