package WorkingWithAbstraction.Lab.HotelReservation;

public class Main {
    public static void main(String[] args) {
        runHoliday();
    }

    private static void runHoliday() {
        ConsoleReader reader = new ConsoleReader();

        String input = reader.readLine();
        String[] tokens = parseArray(input, " ");
        String secondInput = tokens[3].equals("SecondVisit")? String.valueOf(DiscountType.SECOND_VISIT) : tokens[3].toUpperCase();

        PriceCalculator calculator = new PriceCalculator(Double.parseDouble(tokens[0]),
                Integer.parseInt(tokens[1]),
                DiscountType.valueOf(secondInput),
                Season.valueOf(tokens[2].toUpperCase()));

        System.out.printf("%.2f%n", calculator.calculate());
    }

    public static String[] parseArray(String input, String pattern){
        return input.split(pattern);
    }
}
