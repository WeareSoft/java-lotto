package domain.wallet;

public class Wallet {

    private long money;


    public boolean isEmptyWallet() {
        return money <= 0L;
    }
}
