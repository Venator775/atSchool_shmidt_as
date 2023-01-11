package Shmidt.lesson_19_2.ru.pflb.details;

public class Engine {
    //значение мощности двигателя в ваттах
    public int power;
    //название производителя
    public String vendor;

    @Override
    public String toString(){
        return vendor +" - "+ power;
    }


    public Engine(int power,String vendor){
        this.power = power;
        this.vendor = vendor;
    }
}
/*
Создать класс Engine в пакете ru.pflb.details
содержит поля:
    power - значение мощности двигателя в ваттах
    vendor - название производителя
- toString - возвращает строку с информацией о двигателе
  Формат вывода:
    <vendor> - <мощность>
 */
