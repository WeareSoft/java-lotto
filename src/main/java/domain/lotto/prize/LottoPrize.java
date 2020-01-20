package domain.lotto.prize;

import domain.lotto.MatchingInfo;
import domain.lotto.prize.strategy.LottoPrizeStrategy;

public class LottoPrize implements Prizeable {

    private LottoPrizeStrategy strategy;
    private long prize;

    public LottoPrize(LottoPrizeStrategy strategy, long prize) {
        this.strategy = strategy;
        this.prize = prize;
    }

    @Override
    public Long getPrize() {
        return prize;
    }

    @Override
    public boolean isMatching(MatchingInfo matchingInfo) {
        return strategy.isMatching(matchingInfo);
    }

    @Override
    public String toString() {
        return strategy.toString();
    }
}
