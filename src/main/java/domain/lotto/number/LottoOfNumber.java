package domain.lotto.number;

import domain.lotto.Lotto;
import domain.lotto.LottoValueCollection;
import domain.lotto.MatchingInfo;
import java.util.Objects;

public class LottoOfNumber implements Lotto {

    LottoValueCollection values;

    public LottoOfNumber(LottoValueCollection items) {
        this.values = items;
    }

    @Override
    public long getMatching(Lotto target) {
        LottoOfNumber targetValues = (LottoOfNumber) target;
        return targetValues.values.getMatchingSize(values);
    }

    @Override
    public MatchingInfo getMatchingInfo(Lotto winningLotto, Lotto bonusLotto) {
        LottoOfNumber winningLottoValue = (LottoOfNumber) winningLotto;
        long winningMatchCount = winningLottoValue.values.getMatchingSize(values);

        LottoOfNumber bonusLottoValue = (LottoOfNumber) bonusLotto;
        long bonusMatchCount = bonusLottoValue.values.getMatchingSize(values);

        return new MatchingInfo(winningMatchCount, bonusMatchCount);
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
