package domain.actor.impl;

import domain.actor.LottoPrizeable;
import domain.lotto.prize.Prizeable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoPrizer implements LottoPrizeable {

    private Map<Long, Prizeable> prizeableMap;

    public LottoPrizer() {
        this.prizeableMap = new TreeMap<>();
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
    public Map<Long, Prizeable> getAllPrizeInfo() {
        return prizeableMap;
    }
}
