package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.lotto.Lotto;
import domain.seller.LottoSeller;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSellerTest {

    private LottoSeller seller;

    @BeforeEach
    void setUp() {
        this.seller = new LottoSeller();
    }

    @ParameterizedTest(name = "LottoSeller에게 돈{arguments}을 주고 Lotto를 살 수 있다")
    @ValueSource(longs = {1000, 3000, 5000})
    void buyLottoTest(long enoughMoney) {
        List<Lotto> lottos = seller.buyLotto(enoughMoney);

        assertThat(lottos).isNotEmpty();
    }

    @ParameterizedTest(name = "LottoSeller에게 돈 {arguments}으로 Lotto를 살 수 없다")
    @ValueSource(longs = {-1, 0})
    void emptyMoneyBuyLottoTest(long notEnoughMoney) {
        List<Lotto> lottos = seller.buyLotto(notEnoughMoney);

        assertThat(lottos).isEmpty();
    }
}