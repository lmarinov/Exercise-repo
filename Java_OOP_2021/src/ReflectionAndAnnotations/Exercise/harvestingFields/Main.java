package ReflectionAndAnnotations.Exercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Field[] declaredFields = RichSoilLand.class.getDeclaredFields();

		String command = "";

		while (!"HARVEST".equals(command = scanner.nextLine())){
			String modifier = command;
			if (!modifier.equals("all")) {
				Field[] fields = Arrays.stream(declaredFields)
						.filter(e -> Modifier.toString(e.getModifiers()).equals(modifier))
						.toArray(Field[]::new);
				printFields(fields);
			}else{
				printFields(declaredFields);
			}
//			switch (command){
//				case "private":
//					Arrays.stream(declaredFields).filter(e -> Modifier.isPrivate(e.getModifiers())).findFirst().orElseThrow();
//					break;
//				case "public ":
//					break;
//				case "protected":
//					break;
//				case "all":
//					break;
//			}
		}
	}

	private static void printFields(Field[] fields){
		Arrays.stream(fields).forEach(e -> System.out.printf("%s %s %s%n",
				Modifier.toString(e.getModifiers()),
				e.getType().getSimpleName(),
				e.getName()));
	}
}
