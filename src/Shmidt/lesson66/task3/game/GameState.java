package Shmidt.lesson66.task3.game;

public enum GameState {
    STOP("игра остановлена, но не завершена. Начальное состояние игры"),
    RUNNING("игра продолжается"),
    WIN("игра закончилась победой одного из игроков"),
    DRAW("игра закончилась ничьей");

    private String desc;

    public String getDesc() {
        return desc;
    }

    GameState(String desc) {
        this.desc = desc;
    }
}
/*
    находится в пакете game
    Состояния:
        STOP
            игра остановлена, но не завершена. Начальное состояние игры
        RUNNING
            игра продолжается
        WIN
            игра закончилась победой одного из игроков
        DRAW
            игра закончилась ничьей

 */