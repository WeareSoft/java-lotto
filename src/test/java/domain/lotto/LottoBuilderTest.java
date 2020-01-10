package domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import domain.lotto.strategy.LottoValueBuildStrategy;
import fixture.StrategryParameterExtension;
import fixture.StrategryParameterExtension.LottoBuildStrategy;
import fixture.StrategryParameterExtension.StrategyType;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StrategryParameterExtension.class)
class LottoBuilderTest {

    private LottoBuilder builder;

    @BeforeEach
    void setUp() {
        this.builder = new LottoBuilder();
    }

    @Test
    @DisplayName("로또 빌더에게 로또를 만들 수 있다")
    public void test(@LottoBuildStrategy(type = StrategyType.RANDOM) LottoValueBuildStrategy lottoValueBuildStrategy) {
        int size = 7;

        List<Lotto> lottos = builder.size(size).build(lottoValueBuildStrategy);

        assertThat(lottos.size()).isEqualTo(size);
    }

}