package Shmidt.lesson66.task1.records;

import Shmidt.lesson66.task1.system.Account;

import java.math.BigDecimal;

public abstract class Database {
    /**
     * сохраняет указанную сумму на указанный счет
     *
     * @return успешность выполнения операции добавления средств
     */
    public abstract boolean deposit(Account acc, BigDecimal addSum);

    /**
     * снимает указанную сумму с указанного счета
     *
     * @return успешность выполнения операции снятия средств
     */
    public abstract boolean withdraw(Account acc, BigDecimal substractSum);

    /**
     * получает значение суммы с указанного счета
     *
     * @return значение суммы средств на счёте
     */
    protected abstract BigDecimal getAmount(Account acc);

    /**
     * передает указанную сумму с одного указанного счета на другой
     *
     * @param accSender   аккаунт отправителя
     * @param accReceiver аккаунт получателя
     * @param transferSum сумма отправки
     * @return успешность выполнения перевода
     */
    boolean transfer(Account accSender, Account accReceiver, BigDecimal transferSum) {
        boolean successTransfer = false;

        if (getAmount(accSender).compareTo(transferSum) >= 0) {
            if (withdraw(accSender, transferSum)) {//если снятие прошло успешно
                if (deposit(accReceiver, transferSum)) {//если зачисление прошло успешно
                    successTransfer = true;
                } else if (!deposit(accSender, transferSum)) {//если зачисление прошло неуспешно, то вернуть средства отправителю
                    sendErrorLog("Произошла ошибка при возврате средств на счёт отправителя");
                }
            }else sendErrorLog("Произошла ошибка при снятии средств со счёта отправителя");
        }
        return successTransfer;
    }

    private void sendErrorLog(String text) {
        System.out.println(text);
    }
}
/*
Database
    Этот класс является абстрактным шаблоном для реализаций,
    которые будут создаваться в виде наследников этого класса.
    В нем находятся методы, которые наследники обязаны реализовать.
    Или реализации методов по-умолчанию.
    Вам наследников реализовывать не надо.

    находится в пакете com.megabankcorp.system
    содержит заготовки методов
        - deposit - сохраняет указанную сумму на указанный счет
            не содержит реализации, просто сигнатура с описанием
            доступен отовсюду

        - withdraw - снимает указанную сумму с указанного счета
            не содержит реализации, просто сигнатура с описанием
            доступен отовсюду

        - getAmount - получает значение суммы с указанного счета
            не содержит реализации, просто сигнатура с описанием
            доступен только из пакета и реализаций

        - transfer - передает указанную сумму с одного указанного счета на другой
            содержит реализацию по умолчанию, использующую методы deposit и withdraw
            доступен только из пакета

    Для суммы используйте тип BigDecimal.
    Для параметров счетов используете класс Account
 */