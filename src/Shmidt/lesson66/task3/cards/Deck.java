package Shmidt.lesson66.task3.cards;

import java.util.ArrayList;
import java.util.List;

import static Shmidt.tests.sideMethods.rnd;

public class Deck {
    List<Card> cards;

    private List<Card> standardDeck;


    public Deck() {
        initStandardDeck();
        int deckCnt = rnd(1, 2);
        cards = new ArrayList<>();
        while (deckCnt > 0) {
            cards.addAll(standardDeck);
            deckCnt--;
        }
        this.shuffle();
    }

    public Card getTopCard() {
        if (this.cards.size() > 0) {
            shuffle();
            Card topCard = this.cards.get(0);
            this.cards.remove(0);
            System.out.println("Взяли карту сверху: " + topCard);
            return topCard;
        }
        else return null;
    }

    private void shuffle() {
        int cardsCnt = this.cards.size();
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 5; i++) {
                List<Card> miniDeck = new ArrayList<>();
                int miniDeckSize = rnd(2, cardsCnt / 3);
                while (miniDeckSize >= 0) {
                    miniDeck.add(this.cards.get(0));
                    this.cards.remove(0);
                    miniDeckSize--;
                }
                this.cards.addAll(rnd(1, cardsCnt - miniDeck.size()), miniDeck);
            }
            riffleShuffle();
        }
    }

    private void riffleShuffle() {
        List<Card> miniDeck1 = new ArrayList<>();
        List<Card> miniDeck2 = new ArrayList<>();
        for (int i = 0; i < this.cards.size(); i++) {
            if (i < this.cards.size() / 2)
                miniDeck1.add(this.cards.get(i));
            else
                miniDeck2.add(this.cards.get(i));
        }
        List<Card> finalDeck = new ArrayList<>();

        while (miniDeck2.size() > 0 | miniDeck1.size() > 0) {
            if (miniDeck2.size() > 0) {
                finalDeck.add(miniDeck2.get(0));
                miniDeck2.remove(0);
            }
            if (miniDeck1.size() > 0) {
                finalDeck.add(miniDeck1.get(0));
                miniDeck1.remove(0);
            }
        }
        this.cards = finalDeck;
    }

    private void initStandardDeck() {
        standardDeck = new ArrayList<>();
        for (var suit : CardSuit.values()) {
            for (var type : CardType.values()) {
                standardDeck.add(new Card(type, suit));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : this.cards) {
            sb.append(card).append("\n");
        }
        return sb.toString();
    }
}
/*
класс Deck
    находится в пакете cards
    содержит внутренний массив карт Card - внутреннее представление колоды
    конструктор без параметров
        генерируется число от 1 до 8 - число стандартных колод из 52 карт, которые буду замешиваться в общую
        (стандартная колода из 52х карт содержит 13 типов карт по 4 масти)
        создается общая колода
        перетасовывается колода
    внутренний метод shuffle
        случайным образом меняет порядок карт
    общедоступный метод getTopCard
        перемешивает колоду
        возращает карту с верха колоды (с нулевым индексом)
 */