package Shmidt.lesson_19_2.ru.pflb.professions;

import Shmidt.lesson_19_2.ru.pflb.Person;

public class Driver extends Person {


    public int drivingExperience;
    public String licenseId;

    @Override
    public String toString() {
        String parentText = super.toString();
        String text = String.format("\t - стаж (полных лет): %s\n" +
                        "\t - № удостоверения: %s",
                this.drivingExperience,
                this.licenseId);
        return parentText +"\n"+ text;
    }

    public Driver(Person person,
                       int drivingExperience,
                       String licenseId) {
        this.age = person.age;
        this.name = person.name;
        this.drivingExperience = drivingExperience;
        this.licenseId = licenseId;
    }
}
/*
Создать класс Driver в пакете ru.pflb.professions, расширяющих класс Person
Класс содержит поля:
    drivingExperience - кол-во целых лет опыта
    licenseId         - номер водительского удостоверения
Метод toString надо переопределить.
  Формат вывода:
    <name> - возраст: <age>
           - стаж: <drivingExperience>
           - № удостоверения: <licenseId>
 */