package Generics.Exercise.CustomListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class CustomList<E extends Comparable<E>> implements Iterable<E> {
    private List<E> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(E element) {
        this.data.add(element);
    }

    public E remove(int index) {
        return this.data.remove(index);
    }

    public E getMax() {
        E maxEl = this.data.get(0);
        for (E datum : data) {
            if (datum.compareTo(maxEl) > 0) {
                maxEl = datum;
            }
        }

        return maxEl;
    }

    public E getMin() {
        E minEl = this.data.get(0);
        for (E datum : data) {
            if (datum.compareTo(minEl) < 0) {
                minEl = datum;
            }
        }

        return minEl;
    }

    public boolean contains(E element) {
        return this.data.contains(element);
    }

    public void swap(int index1, int index2) {
        E firstElement = this.data.get(index1);
        this.data.set(index1, this.data.get(index2));
        this.data.set(index2, firstElement);
    }

    public E get(int index) {
        return this.data.get(index);
    }

    public int size() {
        return this.data.size();
    }

    public long countGreaterThan(E element) {
        return this.data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public String toString(E value) {

        return value.toString().trim();

    }
    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        for (E t : this) {
            action.accept(t);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public E next() {
                return data.get(index++);
            }
        };
    }
}
