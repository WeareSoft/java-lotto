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
    private Lotto bonusLotto;
    private LottoPrizeable prizeManager;

    public LottoChecker(LottoPrizeable lottoPrizeable) {
        this.prizeManager = lottoPrizeable;
    }

    @Override
    public void settingWinningLotto(Lotto winningLotto) {
        if (isNull(winningLotto)) {
            throw new InvalidParameterException("invalid winning lotto");
        }

        this.winningLotto = winningLotto;
    }

    @Override
    public void settingBonusLotto(Lotto bonusLotto) {
        if (isNull(winningLotto)) {
            throw new InvalidParameterException("invalid bonus lotto");
        }

        this.bonusLotto = bonusLotto;
    }

    @Override
    public List<Prizeable> getLottoPrizeInfo(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> lotto.getMatchingInfo(winningLotto, bonusLotto))
                .map(matchingInfo -> prizeManager.getPrizeInfo(matchingInfo))
                .collect(Collectors.toList());
    }
}
