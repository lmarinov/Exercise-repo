package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        Take architect name and project count from input in the console
        String architectName = scan.nextLine();
        int projectsNum = Integer.parseInt(scan.nextLine());

//        Calculate how many hours it would take to complete all project if it takes 3 hours to make one
        int totalTimeNeeded = projectsNum * 3;

//        Print message
        System.out.printf("The architect %s will need %d hours to complete %d project/s.", architectName, totalTimeNeeded, projectsNum);
    }
}
