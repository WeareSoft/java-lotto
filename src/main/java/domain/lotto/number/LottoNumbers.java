package domain.lotto.number;

import domain.lotto.LottoValueCollection;
import domain.lotto.LottoValueable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers implements LottoValueCollection {

    private List<LottoValueable> values;

    public LottoNumbers(List<Long> numbers) {
        this.values = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    public LottoNumbers(Long number) {
        this.values = Collections.singletonList(new LottoNumber(number));
    }


    @Override
    public long getMatchingSize(LottoValueCollection values) {
        LottoNumbers lotto = (LottoNumbers) values;
        return lotto.values.stream()
                .filter(value -> this.values.contains(value))
                .count();
    }


    @Override
    public String toString() {
        return values.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

    @Override
    public List<LottoValueable> getLottoValues() {
        return values;
    }
}
