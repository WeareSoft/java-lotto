package domain.lotto.strategy;

import domain.lotto.LottoValueCollection;
import domain.lotto.number.LottoNumber;
import domain.lotto.number.LottoNumbers;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberStrategy implements LottoValueBuildStrategy {

    private int size;

    public RandomNumberStrategy(int size) {
        this.size = size;
    }

    @Override
    public LottoValueCollection buildLottoVaules() {
        List<Integer> values = IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(values);

        List<Long> lottoNumbers = values.stream()
                .limit(size)
                .sorted()
                .map(Long::valueOf)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }
}
