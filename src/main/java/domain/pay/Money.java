package domain.pay;

public class Money implements Payable {

    private long money;

    public Money(long money) {
        this.money = money;
    }

    @Override
    public boolean isEmpty() {
        return money <= 0L;
    }

    @Override
    public long getMoney() {
        return money;
    }
}
