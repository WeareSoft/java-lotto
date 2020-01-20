package domain.lotto.prize.strategy.impl;

import domain.lotto.MatchingInfo;
import domain.lotto.prize.strategy.LottoPrizeStrategy;

public class BounsCountPrizeStrategy implements LottoPrizeStrategy {

    private static final String FORMAT = "%d개 일치, 보너스 볼 일치";
    private int winningCount;
    private int bonusCount;

    public BounsCountPrizeStrategy(int winningCount, int bonusCount) {
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
    }

    @Override
    public boolean isMatching(MatchingInfo matchingInfo) {
        return matchingInfo.isMatch(winningCount, bonusCount);
    }

    @Override
    public String toString() {
        return String.format(FORMAT, winningCount);
    }
}
