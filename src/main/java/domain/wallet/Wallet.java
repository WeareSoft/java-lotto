package domain.wallet;

public class Wallet {

    private long money;

    public Wallet(long money) {
        this.money = money;
    }


    public boolean isEmptyWallet() {
        return money <= 0L;
    }
}
