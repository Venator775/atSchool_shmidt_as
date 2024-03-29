package Shmidt.lesson66.task3.game;

import Shmidt.lesson66.task3.Player.Player;
import Shmidt.lesson66.task3.cards.Card;
import Shmidt.lesson66.task3.cards.Deck;

import java.util.Scanner;

import static Shmidt.lesson66.task3.Player.PlayerState.ACTIVE;
import static Shmidt.lesson66.task3.Player.PlayerState.STOP;
import static Shmidt.lesson66.task3.game.GameState.*;

public class Game {
    private Deck currentDeck;
    private Player winner;
    private GameState state;

    private Game() {
        this.state = GameState.STOP;
    }

    private boolean isRunning() {
        return this.state == RUNNING;
    }

    private void start() {
        this.state = RUNNING;
        currentDeck = new Deck();
    }

    private void checkState(Player player1, Player player2) {
        if (!player1.isActive() & !player2.isActive())
            if (player1.getPoints() > player2.getPoints()) {
                winner = player1;
                state = WIN;
            } else if (player1.getPoints() < player2.getPoints()) {
                winner = player2;
                state = WIN;
            } else state = DRAW;
    }

    private Card getTopCard() {
        return currentDeck.getTopCard();
    }

    private void takeTurn(Player player) {
        if (player.isActive()) {
            Card card = getTopCard();
            player.takeCard(card, null);
            System.out.println("Игроку " + player + " дали карту: " + card);
            if (!player.isActive())
                System.out.println(player + " закончил добор карт");
        }
    }

    public void userTurn(Player userPlayer, String command) {
        if (command.equals("more")) {
            Card card = getTopCard();
            userPlayer.takeCard(card, command);
            System.out.println("Игроку " + userPlayer + " дали карту: " + card);
        } else userPlayer.setState(STOP);
    }

    void printResult() {
        System.out.println(state.getDesc());
        if (winner != null)
            System.out.println("Победитель: " + winner + ", с результатом " + winner.getPoints());
    }

    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = new Player("Санёк");
        Player player2 = new Player("Женёк");

        game.start();

        boolean player1TurnFlag = true;//true - player1, false - player2
        int round = 0;
        Scanner sc = new Scanner(System.in);
        String command = "z";
        while (game.isRunning()) {

            if (player1TurnFlag & player1.getState().equals(ACTIVE)) {
                command = sc.next();
                round++;
                System.out.println("\nРаунд " + round);
                game.userTurn(player1, command);

            } else game.takeTurn(player2);

            if (player1.getState().equals(STOP) & player2.getState().equals(STOP))
                game.checkState(player1, player2);

            player1TurnFlag = !player1TurnFlag;
        }
        System.out.println("\nИтоги игры:");
        System.out.println(player1 + ": " + player1.getPoints() + ";\nКарты:\n" + player1.getCardHand().toString());
        System.out.println(player2 + ": " + player2.getPoints() + ";\nКарты:\n" + player2.getCardHand().toString());

        game.printResult();
    }
}
/*
класс Game
    находится в пакете game
    содержит внутреннее поле типа Deck - текущую игровую колоду
    содержит внутреннее поле типа Player - обозначает победиля игры
    содержит внутреннее поле типа GameState - текущее состояние игры

    содержит внутренний конструктор - устанавливает начальное состояние игры STOP
    содержит внутренний метод isRunning - возвращает true, если состояние игры RUNNING
    содержит внутренний метод start
        переводит игру в состояние RUNNING
        создает стартовую колоду
    содержит внутренний метод checkState
        по информации от двух игроков
        проверяет условия завершения игры, согласно описанию выше.
        Если устанавливается победа, то в поле победителя указывается соответствующий объект
            устанавливает состояние игры WIN
        Если устанавливается ничья, то устанавливает состояние игры DRAW
    содержит внутренний метод getTopCard
        достает из текущей колоды карту и возвращает ее
    содержит внутренний метод takeTurn - совершает ход для указанного игрока
        игроку дают карту из колоды
        если игрок активен, то он берет карту
        выводят какую карту дали игроку

    содержит метод с доступом из пакета printResult
        выводит сообщение о результате игры в соответствии с ее состоянием

    метод main
        создается новая игра
        создаются два игрока
        стартует новая игра
        повторяем пока игра продолжается
            по-очереди делаются ходы для каждого игрока
            проверяется завершена ли игра
        если игра завершена, то вывести информацию об игре
 */
