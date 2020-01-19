package domain.lotto.prize.strategy.impl;

import domain.lotto.MatchingInfo;
import domain.lotto.prize.strategy.LottoPrizeStrategy;

public class MatchCountPrizeStrategy implements LottoPrizeStrategy {

    private static final String FORMAT = "%d개 일치";
    private int winningCount;

    public MatchCountPrizeStrategy(int winningCount) {
        this.winningCount = winningCount;
    }

    @Override
    public boolean isMatching(MatchingInfo matchingInfo) {
        return matchingInfo.isMatch(winningCount);
    }

    @Override
    public String toString() {
        return String.format(FORMAT, winningCount);
    }
}
