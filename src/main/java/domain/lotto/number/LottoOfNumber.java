package domain.lotto.number;

import static java.util.Objects.isNull;

import domain.lotto.Lotto;
import domain.lotto.LottoValueCollection;
import domain.lotto.MatchingInfo;
import java.util.Objects;

public class LottoOfNumber implements Lotto {

    private static final long EMPTY = 0;
    private LottoValueCollection values;

    public LottoOfNumber(LottoValueCollection items) {
        this.values = items;
    }

    @Override
    public MatchingInfo getMatchingInfo(Lotto winningLotto, Lotto bonusLotto) {
        return new MatchingInfo(getMatchCount(winningLotto), getMatchCount(bonusLotto));
    }

    private long getMatchCount(Lotto lotto) {
        if (isNull(lotto)) {
            return EMPTY;
        }

        LottoOfNumber lottoValue = (LottoOfNumber) lotto;
        return lottoValue.values.getMatchingSize(values);
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
        return Objects.equals(this.values.getLottoValues(), that.values.getLottoValues());
    }

    @Override
    public String toString() {
        return values.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(values.getLottoValues());
    }
}
