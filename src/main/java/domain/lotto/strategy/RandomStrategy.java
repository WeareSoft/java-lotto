package domain.lotto.strategy;

import domain.lotto.LottoValueable;
import domain.lotto.number.NumberLottoValue;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomStrategy implements LottoValueBuildStrategy {

    @Override
    public List<LottoValueable> buildLottoVaules() {
        List<Integer> values = IntStream.rangeClosed(NumberLottoValue.MIN_VALUE, NumberLottoValue.MAX_VALUE)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(values);

        return values.stream()
                .limit(6)
                .map(NumberLottoValue::new)
                .sorted()
                .collect(Collectors.toList());
    }
}
