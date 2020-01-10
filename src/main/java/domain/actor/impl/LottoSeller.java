package domain.actor.impl;

import domain.actor.LottoBuildable;
import domain.actor.LottoSellable;
import domain.lotto.Lotto;
import domain.lotto.strategy.LottoValueBuildStrategy;
import domain.wallet.Wallet;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.List;

public class LottoSeller implements LottoSellable {

    private LottoBuildable builder;
    private long lottoPrice;

    public LottoSeller(LottoBuildable builder, long price) {
        this.lottoPrice = price;
        this.builder = builder;
    }

    @Override
    public List<Lotto> buyLotto(Wallet wallet, LottoValueBuildStrategy strategy) {
        if (wallet.isEmptyWallet()) {
            return Collections.emptyList();
        }

        return builder.build(getBuyLottoSize(wallet), strategy);
    }

    @Override
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