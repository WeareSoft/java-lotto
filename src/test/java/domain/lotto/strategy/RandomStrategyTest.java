package domain.lotto.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import domain.lotto.LottoValueable;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomStrategyTest {

    @Test
    @DisplayName("로또를 랜덤으로 생성하되 정렬된 상태로 반환한다")
    public void test() {
        LottoValueBuildStrategy strategy = new RandomStrategy();

        List<LottoValueable> lottoValueableList = strategy.buildLottoVaules();

        assertThat(lottoValueableList).isSorted();
    }
}