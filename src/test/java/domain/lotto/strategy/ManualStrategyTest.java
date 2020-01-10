package domain.lotto.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import domain.lotto.LottoValueable;
import domain.lotto.number.LottoNumber;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualStrategyTest {

    @Test
    @DisplayName("로또를 랜덤으로 생성하되 정렬된 상태로 반환한다")
    public void test() {
        List<LottoValueable> value = new ArrayList<>();
        value.add(new LottoNumber(3));
        value.add(new LottoNumber(2));
        value.add(new LottoNumber(1));
        LottoValueBuildStrategy strategy = new ManualStrategy(value);

        List<LottoValueable> lottoValueableList = strategy.buildLottoVaules();

        assertThat(lottoValueableList).isSorted();
    }

}