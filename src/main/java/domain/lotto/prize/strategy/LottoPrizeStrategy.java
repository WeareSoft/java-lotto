package domain.lotto.prize.strategy;

import domain.lotto.MatchingInfo;

public interface LottoPrizeStrategy {

    boolean isMatching(MatchingInfo matchingInfo);
}
