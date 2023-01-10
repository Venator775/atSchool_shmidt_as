package Shmidt.lesson_19_1;

public class Horse  extends Animal{
    static int counter;
    static int foodCounter;
    Horse(String name, HealthState health){
        this.name = name;
        this.health = health;
        food = "Сено, травка, яблочки.... соль О.О";
        location = "В деревнях с человеками";
        counter++;
    }
    @Override
    void makeSound() {
        System.out.println("I-GO-GO mothefucka!");
    }

    @Override
    void eat() {
        System.out.println(String.format("Лошадь ест: %s", food));
        System.out.println(String.format("Осталось травы: %s", --foodCounter));
    }
    void eat(int foodCount) {
        System.out.println(String.format("Пёсик ест: %s", food));
        System.out.println(String.format("Осталось костей: %s", foodCounter-=foodCount));
    }

    @Override
    public String toString() {
        System.out.println("Животное - лошадь\n" +
                "\tКличка:" + name + "\n" +
                "\tСтрана обитания:" + location + "\n" +
                "\tСостояние здоровья:" + health + "\n" +
                "\tСколько особей:" + counter + "\n"
        );
        /*
        Формат вывода:
        <Кличка>
        Страна обитания: ...
        Состояние здоровья: ...
        Сколько особей: ...
        */
        return null;
    }
}
