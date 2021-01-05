package NestedLoops.Lab;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int floors = Integer.parseInt(scan.nextLine());
        int apartments = Integer.parseInt(scan.nextLine());

        for (int currentFloor = floors; currentFloor > 0; currentFloor--){
            for (int currentRoom = 0; currentRoom < apartments; currentRoom++){
                if (currentFloor == floors){
                    System.out.printf("L%d%d ", currentFloor, currentRoom);

                }else if (currentFloor % 2 == 0){
                    if (currentRoom == 0) System.out.printf("%nO%d%d ", currentFloor, currentRoom);
                    else System.out.printf("O%d%d ", currentFloor, currentRoom);

                }else {
                    if (currentRoom == 0) System.out.printf("%nA%d%d ", currentFloor, currentRoom);
                    else System.out.printf("A%d%d ", currentFloor, currentRoom);
                }
            }
        }
    }
}
