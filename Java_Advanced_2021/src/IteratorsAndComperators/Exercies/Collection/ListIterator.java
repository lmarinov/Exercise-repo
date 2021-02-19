package IteratorsAndComperators.Exercies.Collection;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListIterator implements Iterable<String> {
    private List<String> data;
    private int index;


    public ListIterator(List<String> data) {
        this.data = data;
    }

    public boolean move() {
        if (iterator().hasNext()) {
            index++;
            return true;
        }

        return false;
    }

    public void print(){
        validatePrint();
        System.out.println(this.data.get(this.index));
    }

    public void printAll(){
        validatePrint();
        this.data.forEach(e -> System.out.print(e + " "));
    }

//    @Override
//    public void forEach(Consumer<? super String> action){
//        this.data.forEach(action);
//    }

    private void validatePrint() {
        if (this.data.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return index < data.size() - 1;
            }

            @Override
            public String next() {
                String element = data.get(index);
                index++;
                return element;
            }
        };
    }
}
