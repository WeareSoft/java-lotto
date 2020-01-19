package domain.lotto.strategy;

import domain.lotto.LottoValueCollection;
import java.util.Collections;

public class ManualNumberStrategy implements LottoValueBuildStrategy {

    LottoValueCollection values;

    public ManualNumberStrategy(LottoValueCollection list) {
        this.values = list;
    }

    @Override
    public LottoValueCollection buildLottoVaules() {
        Collections.sort(values.getLottoValues());
        return values;
    }
}
