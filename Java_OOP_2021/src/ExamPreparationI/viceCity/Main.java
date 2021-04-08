package ExamPreparationI.viceCity;

import ExamPreparationI.viceCity.core.ControllerImpl;
import ExamPreparationI.viceCity.core.EngineImpl;
import ExamPreparationI.viceCity.core.interfaces.Controller;
import ExamPreparationI.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
