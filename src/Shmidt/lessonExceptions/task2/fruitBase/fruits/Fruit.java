package Shmidt.lessonExceptions.task2.fruitBase.fruits;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import static Shmidt.lessonExceptions.task2.fruitBase.fruits.Freshness.*;
import static Shmidt.tests.sideMethods.rnd;

public abstract class Fruit implements Serializable {
    protected String name;
    protected BigDecimal price;
    protected double weight;
    protected Freshness freshness;

    public Fruit(String name, BigDecimal price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.freshness = FRESH;
    }
    public Fruit(BigDecimal price, double weight) {
        this.price = price;
        this.weight = weight;
        this.freshness = FRESH;
    }

    public Fruit(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    //todo - возможно убрать после уборки имени из фруктов
    public Fruit(Fruit fruit) {
        this(fruit.name, fruit.price, fruit.weight);
    }

    public boolean isFresh() {
        return this.freshness.equals(FRESH);
    }

    public void setRandFresh() {
        int lucky = rnd(1, 3);
        switch (lucky) {
            case (1):
                this.freshness = FRESH;
                break;
            case (2):
                this.freshness = OVERRIPED;
                break;
            case (3):
                this.freshness = SPOILED;
                break;
        }
    }

    abstract public Fruit clone();


    //region get/set
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Freshness getFreshness() {
        return freshness;
    }

    public void setFreshness(Freshness freshness) {
        this.freshness = freshness;
    }
    //endregion

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (name == null ? 0 : name.hashCode());
        result += (price == null ? 0 : price.hashCode());
        result += (int) weight;
        result += (freshness == null ? 0 : freshness.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Fruit fruit = (Fruit) obj;
        return Objects.equals(name, fruit.name)
                && Objects.equals(price, fruit.price)
                && Objects.equals(weight, fruit.weight)
                && Objects.equals(freshness, fruit.freshness);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
/*
    Для фруктов нужно добавить
        - внутренний параметр freshness - отражает состояние свежести фрукта;
          для значений нужно завести enum с как минимум состояниями: FRESH, OVERRIPED, SPOILED
          при создании объект имеет состояние FRESH
        - метод equals
        - метод hashcode
        - метод isFresh - возвращает true, если параметр freshness имеет состояние FRESH
 */
