package domain.seller;

import domain.lotto.Lotto;

public class LottoChecker {

    private Lotto winningLotto;

    public void settingWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public boolean isWinningLotto(Lotto lotto) {
        return winningLotto.equals(lotto);
    }
}
