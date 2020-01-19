package domain.lotto.number;

import static org.assertj.core.api.Assertions.assertThat;

import domain.actor.impl.LottoBuilder;
import domain.lotto.Lotto;
import domain.lotto.LottoValueCollection;
import domain.lotto.strategy.ManualNumberStrategy;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoOfNumberTest {

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

    @Test
    @DisplayName("매칭되는 요소의 개수를 얻을 수 있다")
    public void getMatchingCount() {
        Lotto lotto = generateLotto(1, 6);
        Lotto compareLotto = generateLotto(1, 6);

        assertThat(lotto.getMatching(compareLotto)).isEqualTo(6);
    }


    private Lotto generateLotto(int start, int end) {
        LottoValueCollection values = new LottoNumbers(LongStream.rangeClosed(start, end).boxed().collect(Collectors.toList()));
        List<Lotto> lottos = builder.build(1, new ManualNumberStrategy(values));

        assertThat(lottos.size()).isEqualTo(1);

        return lottos.get(0);
    }
}