package ExceptionsAndErrorHandling.Lab.P04ValidPerson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            new Person("asd", "", 125);
        }catch (IllegalArgumentException | InvalidPersonNameException e){
            System.out.println(e.getMessage());
        }
    }
}
