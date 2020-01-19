package domain.lotto;

import domain.Rank;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto userLotto) {
        int matchCount = lotto.getMatchCount(userLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);
        return Rank.valueOf(matchCount, matchBonus);
    }

    @Override
    public String toString() {
        return String.format("%s + %s", lotto , bonusNumber);
    }
}
