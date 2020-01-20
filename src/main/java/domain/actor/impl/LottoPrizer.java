package domain.actor.impl;

import domain.actor.LottoPrizeable;
import domain.lotto.MatchingInfo;
import domain.lotto.prize.LottoPrize;
import domain.lotto.prize.Prizeable;
import domain.lotto.prize.strategy.impl.BounsCountPrizeStrategy;
import domain.lotto.prize.strategy.impl.MatchCountPrizeStrategy;
import java.util.ArrayList;
import java.util.List;

public class LottoPrizer implements LottoPrizeable {

    private List<Prizeable> prizeInfos;
    public static final Prizeable DUMMY_PRIZE = new LottoPrize(new MatchCountPrizeStrategy(0), 0);

    public LottoPrizer() {
        this.prizeInfos = new ArrayList<>();
        this.prizeInfos.add(new LottoPrize(new MatchCountPrizeStrategy(3), 5000));
        this.prizeInfos.add(new LottoPrize(new MatchCountPrizeStrategy(4), 50000));
        this.prizeInfos.add(new LottoPrize(new MatchCountPrizeStrategy(5), 1500000));
        this.prizeInfos.add(new LottoPrize(new BounsCountPrizeStrategy(5, 1), 3000000));
        this.prizeInfos.add(new LottoPrize(new MatchCountPrizeStrategy(6), 2000000000));
    }


    @Override
    public Prizeable getPrizeInfo(MatchingInfo matchingInfo) {
        return prizeInfos.stream()
                .filter(prize -> prize.isMatching(matchingInfo))
                .findFirst().orElse(DUMMY_PRIZE);
    }

    @Override
    public List<Prizeable> getAllPrizeInfo() {
        return prizeInfos;
    }
}
