package Shmidt.lesson_19_2.ru.pflb;

public class Person {
    public int age;
    public String name;

    @Override
    public String toString() {
        return "Человек: " + name + ", возраст (полных лет): " + age;
    }

    public Person(int age, String name) {
        this.age = age;
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