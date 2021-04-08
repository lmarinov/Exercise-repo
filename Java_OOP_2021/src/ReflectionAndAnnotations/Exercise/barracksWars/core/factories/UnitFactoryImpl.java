package ReflectionAndAnnotations.Exercise.barracksWars.core.factories;

import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"ReflectionAndAnnotations.Exercise.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType){
//		switch (unitType){
//			case "Archer":
//				return new Archer();
//			case "Swordsman":
//				return new Swordsman();
//			case "Horseman":
//				return new Horseman();
//			case "Pikeman":
//				return new Pikeman();
//			case "Gunner":
//				return new Gunner();
//		}
//
//		return null;
		Unit unit = null;
		try {
			Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			unit = (Unit) clazz.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return unit;
	}
}
