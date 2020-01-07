package domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuilderTest {

    private LottoBuilder builder;

    @BeforeEach
    void setUp() {
        this.builder = new LottoBuilder();
    }

    @Test
    @DisplayName("로또 빌더에게 로또를 만들 수 있다")
    public void test() {
        int size = 7;

        List<Lotto> lottos = builder.size(size).build();

        assertThat(lottos.size()).isEqualTo(size);
    }

}