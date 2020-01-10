package domain.lotto.strategy;

import domain.lotto.LottoValueable;
import domain.lotto.number.LottoNumber;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomStrategy implements LottoValueBuildStrategy {

    @Override
    public List<LottoValueable> buildLottoVaules() {
        List<Integer> values = IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(values);

        return values.stream()
                .limit(6) // todo : remove it
                .map(LottoNumber::new) // todo : remove it
                .sorted()
                .collect(Collectors.toList());
    }
}