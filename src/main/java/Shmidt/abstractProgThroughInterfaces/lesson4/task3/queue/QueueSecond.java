package main.java.Shmidt.abstractProgThroughInterfaces.lesson4.task3.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueueSecond {
    private List<Integer> queue;

    public QueueSecond() {
        this.queue = new ArrayList<>();
    }

    public void add(int value) {
        /*List<Integer> tempQueue = new ArrayList<>();
        tempQueue.add(value);
        tempQueue.addAll(this.queue);
        this.queue=tempQueue;*/
        this.queue.add(0,value);
    }

    public int remove() {
        return queue.remove(this.queue.lastIndexOf(Collections.min(this.queue)));
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        if (queue==null)
            return "Очередь не создана";
        if (queue.isEmpty())
            return "Элементы отсутствуют";
        else
            return queue.toString();
    }

    public List<Integer> getQueue() {
        return queue;
    }
}
/*
2) Новые элементы добавляются в начало очереди
   Удаляется наименьший элемент
 */