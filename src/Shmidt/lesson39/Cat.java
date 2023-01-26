package Shmidt.lesson39;

public class Cat extends Animal{
    private int years;
    private double weight;
    private String woolColor;
    private String eyeColor;

    //region constructors
    public Cat() {
        this.years = -1;
        this.weight = -1;
        this.woolColor = "undefined";
        this.eyeColor = "undefined";
    }

    public Cat(int years, double weight, String woolColor, String eyeColor) {
        this.years = years;
        this.weight = weight;
        this.woolColor = woolColor;
        this.eyeColor = eyeColor;
    }

    public Cat(int years, double weight) {
        this.years = years;
        this.weight = weight;
        this.woolColor = "undefined";
        this.eyeColor = "undefined";
    }

    public Cat(String woolColor, String eyeColor) {
        this.years = -1;
        this.weight = -1;
        this.woolColor = woolColor;
        this.eyeColor = eyeColor;
    }

    public Cat(int years, String woolColor) {
        this.years = years;
        this.weight = -1;
        this.woolColor = woolColor;
        this.eyeColor = "undefined";
    }

    //endregion


    @Override
    public String toString() {

        if (years == -1 && weight == -1 && eyeColor.equals("undefined") && woolColor.equals("undefined"))
            return "Кот не определён";

        String info = "Кот:";
        if (years > 0)
            info += "\nВозраст: " + years;
        if (weight > 0)
            info += "\nВес: " + weight;
        if (!eyeColor.equals("undefined"))
            info += "\nЦвет глаз: " + eyeColor;
        if (!woolColor.equals("undefined"))
            info += "\nЦвет шерсти: " + woolColor;

        return info;
    }

}
