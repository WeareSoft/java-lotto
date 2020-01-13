package domain.actor;

import domain.actor.impl.LottoBuilder.LottoType;
import domain.lotto.Lotto;
import domain.lotto.strategy.LottoValueBuildStrategy;
import java.util.List;

public interface LottoBuildable {

    void setLottoType(LottoType lottoType);

    List<Lotto> build(int size, LottoValueBuildStrategy strategy);

    Lotto build(LottoValueBuildStrategy strategy);
}
