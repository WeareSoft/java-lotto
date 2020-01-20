package domain.actor;

import domain.lotto.MatchingInfo;
import domain.lotto.prize.Prizeable;
import java.util.List;

public interface LottoPrizeable {

    Prizeable getPrizeInfo(MatchingInfo matchingInfo);

    List<Prizeable> getAllPrizeInfo();
}
