package Shmidt.lesson_19_2.ru.pflb.professions;

import Shmidt.lesson_19_2.ru.pflb.Person;

public class Driver extends Person {
    public int drivingExperience;
    public String licenseId;

    @Override
    public String toString() {
        return String.format("%s - возраст: %s\n" +
                "\t - стаж: %s\n" +
                "\t - № удостоверения: %s",
                this.name, this.age,
                this.drivingExperience,
                this.licenseId);
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