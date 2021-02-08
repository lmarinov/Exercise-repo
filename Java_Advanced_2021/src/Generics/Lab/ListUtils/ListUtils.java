package ListUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListUtils <T> {

    public static <T extends Comparable<T>> T getMax(List<T> elements){
        ensureNonEmpty(elements);
        return Collections.max(elements);
    }

    private static <T extends Comparable<T>> void ensureNonEmpty(List<T> elements) {
        if (elements.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    public static <T extends Comparable<T>> T getMin(List<T> elements){
        ensureNonEmpty(elements);
        return Collections.min(elements);
    }
}
