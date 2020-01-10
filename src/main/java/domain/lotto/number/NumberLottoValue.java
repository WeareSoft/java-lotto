package domain.lotto.number;

import domain.lotto.LottoValueable;
import java.security.InvalidParameterException;

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
}
