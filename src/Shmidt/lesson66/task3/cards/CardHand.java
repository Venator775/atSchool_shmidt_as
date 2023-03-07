package Shmidt.lesson66.task3.cards;

import java.util.ArrayList;
import java.util.List;

public class CardHand {
    private List<Card> currentHand;

    public CardHand() {
        currentHand = new ArrayList<>();
    }

    public void addHand(Card card) {
        currentHand.add(card);
    }

    public int getPoints() {
        int points = 0;
        for (Card card : currentHand) {
            points += card.getPoints();
        }
        return points;
    }

}
/*
класс CardHand
    находится в пакете cards
    содержит внутренний массив карт Card - текущее состояние руки
    содержит общедоступный конструктор без параметров
        инициализирует внутренний массив
    содержит общедоступный метод addCard
        добавляет карту "в руку"
    содержит общедоступный метод getPoints
        возвращает количество очков "в руке"
 */