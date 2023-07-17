package main.java.Shmidt.generiks.task2;

import java.util.HashMap;
import java.util.Iterator;

public class Basket<T> {
    private HashMap<Plant,T> plantsMap;

    public void addItem(Plant plant) {
        if (plantsMap == null)
            plantsMap = new HashMap<>();
        plantsMap.put(plant,null);
    }

    public HashMap<Plant, T> getPlantsMap() {
        return plantsMap;
    }


    public Iterator<Plant> getIterator(){
        return this.getPlantsMap().keySet().iterator();
    }
}
/*
Вместо массива теперь в классе с корзиной поставить HashMap,
в методе addItem добавлять новые элементы в ключ, подумать, как можно "заглушить" значение value HashMap, так как вам оно точно не понадобится.
Реализовать метод iterator внутри класса корзин, чтобы он возвращал итерратор множества ключей глобального поля HashMap.
 */