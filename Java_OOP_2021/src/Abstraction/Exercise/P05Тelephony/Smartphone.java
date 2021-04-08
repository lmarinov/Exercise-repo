package Abstraction.Exercise.P05Тelephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.setNumbers(numbers);
        this.setUrls(urls);
    }

    private void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    private void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (url.matches("^\\D+$")) {
                sb.append(String.format("Browsing: %s!", url))
                        .append(System.lineSeparator());
            } else {
                sb.append("Invalid URL!")
                        .append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        Pattern pattern = Pattern.compile("^\\d+$");
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (isNumberValid(number, pattern)) {
                sb.append(String.format("Calling...%s", number))
                        .append(System.lineSeparator());
            } else {
                sb.append("Invalid number!")
                        .append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    private boolean isNumberValid(String number, Pattern pattern) {
        Matcher matcher = pattern.matcher(number);
        return matcher.find();
    }
}
