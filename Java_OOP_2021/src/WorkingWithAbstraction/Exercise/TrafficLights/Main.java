package WorkingWithAbstraction.Exercise.TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] initialTrafficLightsStates = reader.readLine().split("\\s+");
        int numberOfUpdates = Integer.parseInt(reader.readLine());
        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String initialTrafficLightsState : initialTrafficLightsStates) {
            TrafficLight trafficLight = new TrafficLight(TrafficLightState.valueOf(initialTrafficLightsState));
            trafficLights.add(trafficLight);
        }

        for (int i = 0; i < numberOfUpdates; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                System.out.print(trafficLight + " ");
            }

            System.out.println();
        }
    }
}
