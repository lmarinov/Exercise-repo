package Polymorphism.Exercise.P05Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Memory {
    private Deque<Integer> savedResults;

    public Integer addToMemory(Integer number){
        if (this.savedResults == null){
            this.savedResults = new ArrayDeque<>();
        }
        this.savedResults.push(number);
        return this.savedResults.peek();
    }

    public int takeLastFromMemory(){
        return this.savedResults.pop();
    }
}
