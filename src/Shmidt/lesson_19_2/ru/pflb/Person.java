package Shmidt.lesson_19_2.ru.pflb;

public class Person {
    private int age;
    private String name;

    @Override
    public String toString() {
        return "Человек: " + name + ", возраст (полных лет): " + age;
    }

    public Person(int age, String name) {
        this.setAge(age);
        this.setName(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*
Сделать абстрактный класс Person в ru.pflb
Класс содержит поля:
    age  - возраст в годах
    name - строка с ФИО
Класс содержит методы:
- toString - возвращает строку с информацией о водителе
 */