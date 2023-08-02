package Shmidt.DEBT.lesson12_2_JDBC.task1.Director;

import java.time.LocalDate;

public class Director {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String country;

    public Director() {
    }
    public Director(int id, String firstName, String lastName, LocalDate birthDate, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.country = country;
    }


    //region getters/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("%d %s %s %s %s", id, firstName, lastName, birthDate, country);
    }
}
