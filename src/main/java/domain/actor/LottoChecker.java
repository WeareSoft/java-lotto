package domain.actor;

import static java.util.Objects.isNull;

import domain.lotto.Lotto;
import java.security.InvalidParameterException;
import java.util.List;

public class LottoChecker implements LottoMatchable {

    private Lotto winningLotto;

    public void settingWinningLotto(Lotto winningLotto) {
        if (isNull(winningLotto)) {
            throw new InvalidParameterException("invalid lotto");
        }

        this.winningLotto = winningLotto;
    }

    public boolean isWinningLotto(Lotto lotto) {
        return winningLotto.equals(lotto);
    }

    @Override
    public LottoMatchingInfo getLottoMatchingInfo(List<Lotto> lottos) {
        return null;
    }
}
