package domain.actor;

import domain.lotto.Lotto;
import domain.lotto.strategy.LottoValueBuildStrategy;
import domain.wallet.Wallet;
import java.util.List;

public interface LottoSellable {

    List<Lotto> buyLotto(Wallet wallet, LottoValueBuildStrategy strategy);

    void setLottoPrice(long settingPrice);
}
