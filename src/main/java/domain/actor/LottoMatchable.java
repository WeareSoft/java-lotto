package domain.actor;

import domain.lotto.Lotto;
import domain.lotto.prize.Prizeable;
import java.util.List;

public interface LottoMatchable {

    List<Prizeable> getLottoPrizeInfo(List<Lotto> lottos);

    void settingWinningLotto(Lotto winningLotto);
}
