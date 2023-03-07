package Shmidt.lesson66.task3.Player;

public enum PlayerState {
    ACTIVE("игрок продолжает брать карты"),
    STOP("игрок больше не будет брать карты");

    private String description;

    PlayerState(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }
}
/*
    Состояния:
        ACTIVE
            игрок продолжает брать карты
        STOP
            игрок больше не будет брать карты
 */