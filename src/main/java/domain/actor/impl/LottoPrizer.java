package domain.actor.impl;

import domain.actor.LottoPrizeable;
import domain.lotto.prize.LottoPrize;
import domain.lotto.prize.Prizeable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LottoPrizer implements LottoPrizeable {

    private Map<Long, Prizeable> prizeableMap;

    public LottoPrizer() {
        this.prizeableMap = new TreeMap<>();
        prizeableMap.put(3L, new LottoPrize(3, 5000));
        prizeableMap.put(4L, new LottoPrize(4, 50000));
        prizeableMap.put(5L, new LottoPrize(5, 1500000));
        prizeableMap.put(6L, new LottoPrize(6, 2000000000));
    }

    @Override
    public void setPrizeInfo(List<Prizeable> prizeInfos) {
        for (Prizeable prizeItem : prizeInfos) {
            prizeableMap.put(prizeItem.getMatchCount(), prizeItem);
        }
    }

    @Override
    public Prizeable getPrizeInfo(Long matchCount) {
        return prizeableMap.get(matchCount);
    }

    @Override
    public Set<Long> getPrizeMatchCounts() {
        return prizeableMap.keySet();
    }
}
