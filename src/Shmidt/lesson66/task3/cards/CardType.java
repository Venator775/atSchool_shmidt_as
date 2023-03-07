package Shmidt.lesson66.task3.cards;

public enum CardType {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);

    private int points;

    CardType(int p) {
        this.points = p;
    }

    protected int getPoints() {
        return points;
    }
}
/*
enum CardType
    находится в пакете cards
    параметр очки
    TWO
    THREE
    FOUR
    FIVE
    SIX
    SEVEN
    EIGHT
    NINE
    TEN
    JACK
    QUEEN
    KING
    ACE
    конструктор, который устанавливает значение очков
    метод, доступный в пакете, getPoints
        возвращает число очков для типа
 */