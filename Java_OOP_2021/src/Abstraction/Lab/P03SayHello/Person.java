package Abstraction.Lab.P03SayHello;

public interface Person {
    String getName();

    default String sayHello(){
        return "Hello";
    }
}
