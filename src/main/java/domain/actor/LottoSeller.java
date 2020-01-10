package domain.actor;

import domain.lotto.Lotto;
import domain.lotto.LottoBuilder;
import domain.lotto.strategy.LottoValueBuildStrategy;
import domain.wallet.Wallet;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.List;

public class LottoSeller {

    private LottoBuilder builder;
    private long lottoPrice;

    public LottoSeller(LottoBuilder builder) {
        this.builder = builder;
    }

    public List<Lotto> buyLotto(Wallet wallet, LottoValueBuildStrategy strategy) {
        if (wallet.isEmptyWallet()) {
            return Collections.emptyList();
        }

        return builder.size(getBuyLottoSize(wallet))
                .build(strategy);
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