package Polymorphism.Exercise.P05Calculator;

public class InputInterpreter {
    private CalculationEngine engine;
    private Memory memory;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
        this.memory = new Memory();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }else if(operation.equals("ms")){
            memory.addToMemory(engine.getCurrentResult());
        }else if(operation.equals("mr")){
            int returnedNumberFromMemory = memory.takeLastFromMemory();
            engine.pushNumber(returnedNumberFromMemory);
        }else if(operation.equals("/")){
            return new DivisionOperation();
        }

        return null;
    }
}
