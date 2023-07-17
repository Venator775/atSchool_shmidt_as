package main.java.Shmidt.lesson66.task3.cards;

public enum CardSuit {
    DIAMONDS("♦"),
    HEARTS("♥"),
    SPADES("♠"),
    CLUBS("♣");


    private String icon;

    CardSuit(String icon)
    {
        this.icon = icon;
    }
}
