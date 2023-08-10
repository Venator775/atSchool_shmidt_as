package Shmidt.lesson7_9_StreamAPI.task1;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket<T> {
    private ArrayList<T> plants;

    private HashMap<Plant,T> plantsMap;

    public void addItem(T plant) {
        if (plants == null)
            plants = new ArrayList<>();

        plants.add(plant);
    }

    public void addItemToMap(Plant plant) {
        if (plantsMap == null)
            plantsMap = new HashMap<>();
        plantsMap.put(plant,null);
    }

    public ArrayList<T> getPlants() {
        return plants;
    }

    public HashMap<Plant, T> getPlantsMap() {
        return plantsMap;
    }
}
