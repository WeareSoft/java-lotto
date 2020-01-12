package domain.pay;

public class Wallet implements Payable {

    private long money;

    public Wallet(long money) {
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
