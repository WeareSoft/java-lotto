package domain.actor;

import domain.lotto.prize.Prizeable;
import java.util.List;
import java.util.Map;

public interface LottoPrizeable {

    void setPrizeInfo(List<Prizeable> prizeInfos);

    Prizeable getPrizeInfo(Long matchCount);

    Map<Long, Prizeable> getAllPrizeInfo();
}
