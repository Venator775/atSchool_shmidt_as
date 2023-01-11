package Shmidt.lesson_19_2.ru.pflb.professions;

import Shmidt.lesson_19_2.ru.pflb.Person;

public class Driver extends Person {
    private int drivingExperience;
    private String licenseId;

    public Driver(Person person,
                  int drivingExperience,
                  String licenseId) {
        super(person.getAge(), person.getName());
        this.drivingExperience = drivingExperience;
        this.licenseId = licenseId;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "\t - стаж (полных лет): " + this.drivingExperience + "\n"
                + "\t - № удостоверения: " + this.licenseId;
    }


    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
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