package domain.lotto.prize;

import domain.lotto.MatchingInfo;

public interface Prizeable {

    Long getPrize();

    boolean isMatching(MatchingInfo matchingInfo);
}