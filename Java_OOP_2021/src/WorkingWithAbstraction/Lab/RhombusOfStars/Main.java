package WorkingWithAbstraction.Lab.RhombusOfStars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        int maximumStars = Integer.parseInt(InputReader());

        createTriangleOfStars(maximumStars);
        createReversedTriangleOfStars(maximumStars);
    }

    private static void createTriangleOfStars(int maximumStars) {
        for (int currentNumberOfStars = 1; currentNumberOfStars < maximumStars; currentNumberOfStars++) {
            printRow(currentNumberOfStars, maximumStars - currentNumberOfStars);
        }
    }

    private static void createReversedTriangleOfStars(int maximumStars) {
        for (int currentNumberOfStars = maximumStars; currentNumberOfStars > 0; currentNumberOfStars--) {
            printRow(currentNumberOfStars, maximumStars - currentNumberOfStars);
        }
    }

    private static void printRow(int stars, int spaces) {
        if (spaces == 0){
            if (stars > 0){
                System.out.print("* ");
                printRow(stars - 1, spaces);
            }else{
                System.out.println();
            }
        }else{
            System.out.print(" ");
            printRow(stars, spaces - 1);
        }
    }

    public static String InputReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}
