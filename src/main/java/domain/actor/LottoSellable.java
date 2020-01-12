package domain.actor;

import domain.lotto.Lotto;
import domain.lotto.strategy.LottoValueBuildStrategy;
import domain.pay.Payable;
import java.util.List;

public interface LottoSellable {

    List<Lotto> buyLotto(Payable payment, LottoValueBuildStrategy strategy);

    void setLottoPrice(long settingPrice);
}
