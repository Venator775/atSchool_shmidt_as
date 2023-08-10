package Shmidt.lesson7_9_StreamAPI.task21;

import java.util.HashMap;

public class Basket<T> {
    private HashMap<String,T> plantsMap;

    public void addItemToMap(Plant plant) {
        if (plantsMap == null)
            plantsMap = new HashMap<>();
        plantsMap.put(plant.getName(), (T) plant);
    }


    public HashMap<String, T> getPlantsMap() {
        return plantsMap;
    }

    public int size(){
        return plantsMap.size();
    }
}
