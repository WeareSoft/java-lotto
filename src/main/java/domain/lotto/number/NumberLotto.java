package domain.lotto.number;

import domain.lotto.Lotto;
import domain.lotto.LottoValueable;
import java.util.List;

public class NumberLotto implements Lotto {

    List<LottoValueable> values;

    public NumberLotto(List<LottoValueable> items) {
        this.values = items;
    }
}
