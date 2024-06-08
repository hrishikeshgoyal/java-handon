package org.example.trafficsignalsystem;

import java.util.HashMap;
import java.util.Map;

public class TrafficController {
    private static TrafficController instance;
    private final Map<String, Road> roads;

    private TrafficController() {
        roads = new HashMap<>();
    }

    public static synchronized TrafficController getInstance() {
        if (instance == null) {
            instance = new TrafficController();
        }
        return instance;
    }

    public void addRoad(Road road) {
        roads.put(road.getId(), road);
    }

    public void removeRoad(String roadId) {
        roads.remove(roadId);
    }

    public void startTrafficControl() {
        while(true) {
            for (var id : roads.keySet()) {
                Signal[] lightsInOrder = {Signal.YELLOW, Signal.GREEN};
                for(var s: lightsInOrder) {
                    roads.keySet().forEach(k -> {
                        if (k.equals(id)) {
                            System.out.printf("road: %s, signal:%s\n", k, s);
                            roads.get(k).getTrafficLight().changeSignal(s);
                        } else {
                            System.out.printf("road: %s, signal:%s\n", k, "RED");
                            roads.get(k).getTrafficLight().changeSignal(Signal.RED);
                        }
                    });
                    System.out.println("---------------------");
                    try {
                        Thread.sleep(roads.get(id).getTrafficLight().getDuration(s));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void handleEmergency(String roadId) {
        Road road = roads.get(roadId);
        if (road != null) {
            TrafficLight trafficLight = road.getTrafficLight();
            trafficLight.changeSignal(Signal.GREEN);
            // Perform emergency handling logic
            // ...
        }
    }
}
