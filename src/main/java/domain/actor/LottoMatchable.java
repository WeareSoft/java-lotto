package domain.actor;

import domain.lotto.Lotto;
import java.util.List;

public interface LottoMatchable {

    LottoMatchingInfo getLottoMatchingInfo(List<Lotto> lottos);
}
