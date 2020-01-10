package domain.lotto.strategy;

import domain.lotto.LottoValueable;
import java.util.List;
import java.util.stream.Collectors;

public class ManualNumberStrategy implements LottoValueBuildStrategy {

    List<LottoValueable> values;

    public ManualNumberStrategy(List<LottoValueable> list) {
        this.values = list;
    }

    @Override
    public List<LottoValueable> buildLottoVaules() {
        return values.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
