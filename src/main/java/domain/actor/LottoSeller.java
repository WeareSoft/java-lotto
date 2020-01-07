package domain.actor;

import domain.lotto.Lotto;
import domain.wallet.Wallet;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSeller {

    private long lottoPrice;

    public List<Lotto> buyLotto(Wallet wallet) {
        if (wallet.isEmptyWallet()) {
            return Collections.emptyList();
        }

        List<Lotto> buyLottoes = new ArrayList<>();
        for (int i = 0; i < getBuyLottoSize(wallet); i++) {
            buyLottoes.add(new Lotto());
        }

        return buyLottoes;
    }

    public void setLottoPrice(long settingPrice) {
        if (settingPrice <= 0) {
            throw new InvalidParameterException("invalid lotto price");
        }

        this.lottoPrice = settingPrice;
    }

    private int getBuyLottoSize(Wallet wallet) {
        return (int) (wallet.getMoney() / lottoPrice);
    }
}