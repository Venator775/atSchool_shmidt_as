package Shmidt.lambdas.task3.queue;

import java.util.ArrayList;
import java.util.Collections;
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

    public void sort(Swap method) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < queue.size() - 1; i++) {
                if (method.needToSwap(queue.get(i), queue.get(i + 1))) {
                    Collections.swap(queue, i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    @Override
    public String toString() {
        if (queue == null)
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