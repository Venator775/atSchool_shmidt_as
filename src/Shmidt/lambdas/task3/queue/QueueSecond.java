package Shmidt.lambdas.task3.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueueSecond {
    private List<Integer> queue;

    public QueueSecond() {
        this.queue = new ArrayList<>();
    }

    public void add(int value) {
        this.queue.add(0, value);
    }

    public int remove() {
        return queue.remove(this.queue.lastIndexOf(Collections.min(this.queue)));
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
2) Новые элементы добавляются в начало очереди
   Удаляется наименьший элемент
 */