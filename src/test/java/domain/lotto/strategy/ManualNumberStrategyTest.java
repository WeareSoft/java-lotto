package domain.lotto.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import domain.lotto.LottoValueCollection;
import fixture.StrategryParameterExtension;
import fixture.StrategryParameterExtension.LottoBuildStrategy;
import fixture.StrategryParameterExtension.StrategyType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StrategryParameterExtension.class)
class ManualNumberStrategyTest {

    @Test
    @DisplayName("로또를 매뉴얼로 생성하되 정렬된 상태로 반환한다")
    public void test(@LottoBuildStrategy(type = StrategyType.MANUAL, item = {4, 3, 5, 1}) LottoValueBuildStrategy strategy) {
        LottoValueCollection lottoValueableList = strategy.buildLottoVaules();

        assertThat(lottoValueableList.getLottoValues()).isSorted();
    }

}