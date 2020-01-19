package domain.actor;

import domain.lotto.prize.Prizeable;
import java.util.List;
import java.util.Set;

public interface LottoPrizeable {

    void setPrizeInfo(List<Prizeable> prizeInfos);

    Prizeable getPrizeInfo(Long matchCount);

    Set<Long> getPrizeMatchCounts();
}
