package Abstraction.Lab.P04SayHelloExtend;

public interface Person {
    String getName();

    default String sayHello(){
        return "Hello";
    }
}
