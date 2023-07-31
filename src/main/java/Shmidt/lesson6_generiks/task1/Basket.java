package Shmidt.lesson6_generiks.task1;

import java.util.ArrayList;

public class Basket<T> {
    private ArrayList<T> plants;

    public void addItem(T plant) {
        if (this.plants == null)
            this.plants = new ArrayList<>();

        plants.add(plant);
    }

    public ArrayList<T> getPlants() {
        return plants;
    }
}
