package Shmidt.lambdas.task3.queue;


public interface Queue {
    /**
     * добавляет целочисленное значение в очередь
     *
     * @param value
     */
    void add(int value);

    /**
     * удаляет значение из очереди
     *
     * @return
     */
    int remove();

    /**
     * возвращает true, если в очереди нет элементов
     *
     * @return
     */
    boolean isEmpty();

    /**
     * Сортировка массива
     *
     * @param method
     */
    void sort(Swap method);


}
