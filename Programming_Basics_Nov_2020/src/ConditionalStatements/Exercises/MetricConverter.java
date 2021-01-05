package ConditionalStatements.Exercises;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double initialMeasurement = Double.parseDouble(sc.nextLine());
        String measurementType = sc.nextLine();
        String conversionType = sc.nextLine();

        double result = 0.0;
        switch (measurementType){
            case "m":
                if (conversionType.equals("cm")){
                    result = initialMeasurement * 100;
                }else if (conversionType.equals("mm")){
                    result = initialMeasurement * 1000;
                }else {
                    System.out.print("Invalid conversion unit!");
                }
                break;
            case "mm":
                if (conversionType.equals("cm")){
                    result = initialMeasurement / 10;
                }else if (conversionType.equals("m")){
                    result = initialMeasurement / 1000;
                }else {
                    System.out.print("Invalid conversion unit!");
                }
                break;
            case "cm":
                if (conversionType.equals("m")){
                    result = initialMeasurement / 100;
                }else if (conversionType.equals("mm")){
                    result = initialMeasurement * 10;
                }else {
                    System.out.print("Invalid conversion unit!");
                }
                break;

        }
        System.out.printf("%.3f", result);
    }
}
