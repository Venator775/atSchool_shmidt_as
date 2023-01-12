package Shmidt.lesson_19_1;

public abstract class Animal {
    //Кличка
    public String name;
    //Название типа пищи
    public String food;
    //Кол-во запасов пищи
//    public int foodCounter;
    //название страны обитания
    public String location;
    //все животные имеют внутреннюю связь с сородичами, в переменной содержится общее кол-во осыбей данного вида
    public int counter;
    //состояние здоровья животного
    public HealthState health;

    /**
     * выводит текст, как звучит животное
     */
    abstract void makeSound();

    /**
     * - eat - выводит текст, что животное ест;
     * уменьшает кол-во еды у животного;
     * также выводит сколько запасов осталось
     */
    public void eat(int foodCounter ) {
        if (foodCounter == 0)
            System.out.println("Еды для " + this.name + " нет!");
        else {
            System.out.println(this.name + " ест: " + food);
            System.out.println("Осталось еды(" + this.food + "): " + --foodCounter);
        }
    }
    abstract void eat();

    /**
     * выводит текст, что животное спит
     */
    void sleep() {
        System.out.println(String.format("%s спит", this.name));
    }


    public String toString() {
        return "Животное - %s\n" +
                "\tКличка:" + name + "\n" +
                "\tСтрана обитания:" + location + "\n" +
                "\tСостояние здоровья:" + health + "\n" +
                "\tСколько особей: %d";
    }
}
/*
Создать класс Animal и расширяющие его классы Dog, Cat, Horse.


Класс Animal - абстрактный.

Содержит параметры:
- name - кличка животного
- food - название типа пищи
- foodCounter - кол-во запасов пищи
- location - название страны обитания
- counter - все животные имеют внутреннюю связь с сородичами,
    в переменной содержится общее кол-во осыбей данного вида

- health - состояние здоровья животного типа HealthState
Возможные значения HealthState
  HEALTHY,
  UNHEALTHY

Класс Animal содержит методы:
- makeSound - выводит текст, как звучит животное
- eat - выводит текст, что животное ест;
          уменьшает кол-во еды у животного;
          также выводит сколько запасов осталось
- sleep - выводит текст, что животное спит
- toString - вовзращает в виде строки текущую информацию об особи
Формат вывода:
<Кличка>
  Страна обитания: ...
  Состояние здоровья: ...
  Сколько особей: ...
*/