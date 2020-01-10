package domain.actor.impl;

import static java.util.Objects.isNull;

import domain.actor.LottoMatchable;
import domain.actor.LottoPrizeable;
import domain.lotto.Lotto;
import domain.lotto.prize.Prizeable;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

public class LottoChecker implements LottoMatchable {

    private Lotto winningLotto;
    private LottoPrizeable prizeManager;

    public LottoChecker(LottoPrizeable lottoPrizeable) {
        this.prizeManager = lottoPrizeable;
    }

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
    public List<Prizeable> getLottoPrizeInfo(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> winningLotto.getMatching(lotto))
                .map(matchCount -> prizeManager.getPrizeInfo(matchCount))
                .collect(Collectors.toList());
    }
}
