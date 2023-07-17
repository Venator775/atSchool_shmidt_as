package Shmidt.lesson66.task3.Player;

import Shmidt.lesson66.task3.cards.Card;
import Shmidt.lesson66.task3.cards.CardHand;

import static Shmidt.lesson66.task3.Player.PlayerState.ACTIVE;
import static Shmidt.lesson66.task3.Player.PlayerState.STOP;
import static Shmidt.tests.sideMethods.rnd;

public class Player {
    private int nervous;

    public void setState(PlayerState state) {
        this.state = state;
    }

    public PlayerState getState() {
        return state;
    }

    private PlayerState state;

    public CardHand getCardHand() {
        return cardHand;
    }

    private CardHand cardHand;

    private String name;

    public Player(String name) {
        this.name = name;
        this.nervous = 0;
        this.state = ACTIVE;
        this.cardHand = new CardHand();
    }

    private void checkState() {
        int points = this.cardHand.getPoints();

        if (points == 19 | points == 20 | points == 21) {
            this.state = STOP;
            return;
        }

        if (points > 10) {
            for (int i = 0; i < points - 10; i++)
                nervous++;

            int nerv = rnd(0, 9);
            if (nerv < this.nervous)
                this.state = STOP;
        }
    }

    public boolean isActive() {
        return this.state == ACTIVE;
    }

    public void takeCard(Card card, String command) {
        cardHand.addHand(card);
        if (command == null)
            checkState();
    }

    public int getPoints() {
        return cardHand.getPoints();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
/*
класс Player
    находится в пакете player
    содержит внутренний параметр нервозности игрока - целое положительное число
    содержит внутренний параметр состояния игрока PlayerState
    содержит внутренний параметр CardHand - текущая рука, которую игрок собрал на данный момент
    содержит внутренний параметр имя игрока

    содержит конструктор, который принимает имя игрока в качестве параметра
        устанавливает имя игрока
        устанавливает параметр нервозности в 0
        устанавливает параметр состояния игрока в ACTIVE
        инициализирует руку игрока
    содержит внутренний метод checkState проверяет состояние игрока - продолжает он или нет
        подсчитывает число очков в руке
        если "в руке" 19, 20 или 21 очко, то состояние становится STOP, на этом проверка останавливается
        если "в руке" очков больше 10, то за каждое очко увеличивается параметр нервозности на 1
        генериться случайное целое число от 0 до 10, 10 не включая
        если случайное число меньше текущей нервозности, то состояние игрока становится STOP

    содержит общедоступный метод isActive
        возвращает true, если текущее состояние игрока ACTIVE
    содержит общедоступный метод takeCard - положить переданную карту в руку
        полученную карту добавляет в руку
        проверяет состояние игрока
    содержит общедоступный метод getPoints
        подсчитывает и возвращает кол-во очков "в руке"
    содержит общедоступный метод toString
        возвращает имя игрока
 */