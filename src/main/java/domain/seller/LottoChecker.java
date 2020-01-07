package domain.seller;

import static java.util.Objects.isNull;

import domain.lotto.Lotto;
import java.security.InvalidParameterException;

public class LottoChecker {

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
}
