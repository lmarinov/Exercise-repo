package Inheritance.Lab.StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String str){
        this.data.add(str);
    }

    public String peek(){
        if (isEmpty()){
            return null;
        }

        return this.data.get(this.data.size() -1);
    }

    public String pop(){
        if (isEmpty()){
            return null;
        }

        return this.data.remove(this.data.size() - 1);
    }

    public boolean isEmpty(){
        return this.data.size() <= 0;
    }
}
