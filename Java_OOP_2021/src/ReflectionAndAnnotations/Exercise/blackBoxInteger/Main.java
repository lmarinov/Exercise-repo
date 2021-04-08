package ReflectionAndAnnotations.Exercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> declaredConstructor = BlackBoxInt.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();
        Method[] declaredMethods = blackBoxInt.getClass().getDeclaredMethods();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String line;

        while (!"END".equals(line = scanner.nextLine())){
            String[] tokens = line.split("_");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            Method currentMethod = Arrays.stream(declaredMethods).filter(method -> method.getName().equals(command)).findFirst().get();
            currentMethod.setAccessible(true);
            currentMethod.invoke(blackBoxInt, number);

            System.out.println(innerValue.getInt(blackBoxInt));
        }
    }
}
