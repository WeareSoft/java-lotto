package domain.lotto.number;

import domain.lotto.Lotto;
import domain.lotto.LottoValueable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoOfNumber implements Lotto {

    List<LottoValueable> values;

    public LottoOfNumber(List<LottoValueable> items) {
        this.values = items;
    }

    @Override
    public long getMatching(Lotto target) {
        LottoOfNumber lotto = (LottoOfNumber) target;
        return lotto.values.stream()
                .filter(value -> values.contains(value))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoOfNumber that = (LottoOfNumber) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public String toString() {
        return values.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
