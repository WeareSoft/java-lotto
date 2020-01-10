package domain.lotto.number;

import domain.lotto.LottoValueable;
import java.security.InvalidParameterException;
import java.util.Objects;

public class NumberLottoValue implements LottoValueable {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private long value;

    public NumberLottoValue(long value) {
        if (isSupportLottoValue(value)) {
            throw new InvalidParameterException("invalid lotto value");
        }

        this.value = value;
    }

    private boolean isSupportLottoValue(long value) {
        return MAX_VALUE < value || MIN_VALUE > value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NumberLottoValue that = (NumberLottoValue) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(LottoValueable targetValue) {
        NumberLottoValue target = (NumberLottoValue) targetValue;
        if (target.value > this.value) {
            return -1;
        } else if (target.value < this.value) {
            return 1;
        }

        return 0;
    }
}
