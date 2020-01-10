package domain.lotto.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import domain.lotto.LottoValueable;
import fixture.StrategryParameterExtension;
import fixture.StrategryParameterExtension.LottoBuildStrategy;
import fixture.StrategryParameterExtension.StrategyType;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StrategryParameterExtension.class)
class RandomNumberStrategyTest {

    @Test
    @DisplayName("로또를 랜덤으로 생성하되 정렬된 상태로 반환한다")
    public void test(@LottoBuildStrategy(type = StrategyType.RANDOM, size = 10) LottoValueBuildStrategy strategy) {
        List<LottoValueable> lottoValueableList = strategy.buildLottoVaules();

        assertThat(lottoValueableList).isSorted();
    }
}