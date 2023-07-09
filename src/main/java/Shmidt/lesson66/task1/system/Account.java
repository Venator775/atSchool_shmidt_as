package Shmidt.lesson66.task1.system;

import java.math.BigDecimal;

public class Account {
    private BigDecimal sum;
    private long accId;
    private long clientId;

    public Account(long clientId, long accId, BigDecimal sum) {
        this.sum = sum;
        this.accId = accId;
        this.clientId = clientId;
    }

    public Account(long clientId, long accId) {
        this.accId = accId;
        this.clientId = clientId;
        this.sum = BigDecimal.valueOf(0);
    }

    public BigDecimal getSum() {
        return sum;
    }

    public long getAccId() {
        return accId;
    }

    public long getClientId() {
        return clientId;
    }
}
/*
Account
    это простой класс, который находится в пакете com.megabankcorp.records
    содержит
        поле для текущей суммы на счете
        поле для текущего номера счета
        поле для номера клиента банка

    Для суммы используйте тип BigDecimal, для номеров - long
 */