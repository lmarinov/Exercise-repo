package Generics.Exercise.GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Count <T extends Comparable>{

    private List<T> values;

    public Count() {
        this.values = new ArrayList<>();
    }

    public void addValue (T value){
        this.values.add(value);
    }

    public long countGreaterElements(T elementToCompare){
       return this.values.stream().filter(e -> e.compareTo(elementToCompare) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb
                    .append(String.format("%s: %s", value.getClass().getName(), value.toString()))
                    .append(System.lineSeparator());

        }
        return sb.toString().trim();

    }

}
