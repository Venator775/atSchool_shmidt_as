package Shmidt.generiks.task2;

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
/*
Вместо массива теперь в классе с корзиной поставить HashMap,
в методе addItem добавлять новые элементы в ключ, подумать, как можно "заглушить" значение value HashMap, так как вам оно точно не понадобится.
Реализовать метод iterator внутри класса корзин, чтобы он возвращал итерратор множества ключей глобального поля HashMap.
 */