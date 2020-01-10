package domain.lotto;

import domain.lotto.number.NumberLotto;
import domain.lotto.strategy.LottoValueBuildStrategy;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBuilder {

    private int size;

    public LottoBuilder size(int size) {
        this.size = size;
        return this;
    }

    public List<Lotto> build(LottoValueBuildStrategy strategy) {
        List<LottoValueable> values = strategy.buildLottoVaules();

        return IntStream.range(0, size)
                .mapToObj((value) -> new NumberLotto(values))
                .collect(Collectors.toList());
    }
}
