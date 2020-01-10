package domain.actor.impl;

import domain.actor.LottoBuildable;
import domain.lotto.Lotto;
import domain.lotto.LottoValueable;
import domain.lotto.number.NumberLotto;
import domain.lotto.strategy.LottoValueBuildStrategy;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBuilder implements LottoBuildable {

    public List<Lotto> build(int size, LottoValueBuildStrategy strategy) {
        return IntStream.range(0, size)
                .mapToObj((value) -> {
                    List<LottoValueable> values = strategy.buildLottoVaules();
                    return new NumberLotto(values); // TODO: remove it
                })
                .collect(Collectors.toList());
    }
}
