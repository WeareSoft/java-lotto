package domain.actor;

import domain.lotto.Lotto;
import domain.lotto.strategy.LottoValueBuildStrategy;
import java.util.List;

public interface LottoBuildable {

    List<Lotto> build(int size, LottoValueBuildStrategy strategy);
}
