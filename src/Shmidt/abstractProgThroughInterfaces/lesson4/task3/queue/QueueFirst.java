package Shmidt.abstractProgThroughInterfaces.lesson4.task3.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueFirst implements Queue {
    private List<Integer> queue;

    public QueueFirst() {
        this.queue = new ArrayList<>();
    }

    public void add(int value) {
        queue.add(value);
    }

    public int remove() {
        return queue.remove(0);
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
1) Новые элементы добавляются в конец очереди
   Существующие элементы удаляются из начала очереди
 */