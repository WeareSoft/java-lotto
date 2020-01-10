package domain.lotto.number;

import static org.assertj.core.api.Assertions.assertThat;

import domain.lotto.Lotto;
import domain.lotto.LottoBuilder;
import domain.lotto.LottoValueable;
import domain.lotto.strategy.ManualStrategy;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberLottoTest {

    private LottoBuilder builder;

    @BeforeEach
    public void setUp() {
        this.builder = new LottoBuilder();
    }

    @Test
    @DisplayName("구성 요소가 같으면 equals도 true를 반환한다")
    public void whenItemValueisSameReturnEqualsTrue() {
        Lotto lotto = generateLotto(1, 6);
        Lotto compareLotto = generateLotto(1, 6);

        assertThat(lotto).isEqualTo(compareLotto);
    }

    @Test
    @DisplayName("구성 요소가 다른 경우 equals도 false를 반환한다")
    public void whenItemValueisDifferentReturnEqualsfalse() {
        Lotto lotto = generateLotto(1, 6);
        Lotto compareLotto = generateLotto(2, 7);

        assertThat(lotto).isNotEqualTo(compareLotto);
    }


    private Lotto generateLotto(int start, int end) {
        List<LottoValueable> values = IntStream.rangeClosed(start, end)
                .mapToObj(NumberLottoValue::new)
                .collect(Collectors.toList());

        List<Lotto> lottos = builder.size(1).build(new ManualStrategy(values));

        assertThat(lottos.size()).isEqualTo(1);

        return lottos.get(0);
    }
}