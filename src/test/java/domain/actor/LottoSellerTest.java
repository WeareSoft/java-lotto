package domain.actor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.lotto.Lotto;
import domain.lotto.LottoBuilder;
import domain.wallet.Wallet;
import java.security.InvalidParameterException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSellerTest {

    private LottoSeller seller;

    @BeforeEach
    void setUp() {
        this.seller = new LottoSeller(new LottoBuilder());
    }

    @ParameterizedTest(name = "LottoSeller에게 돈{arguments}을 주고 Lotto를 살 수 있다")
    @ValueSource(longs = {1000, 3000, 5000})
    void buyLottoTest(long enoughMoney) {
        final long lottoPrice = 1000L;
        final long buyLottoSize = enoughMoney / lottoPrice;
        seller.setLottoPrice(lottoPrice);

        List<Lotto> lottos = seller.buyLotto(new Wallet(enoughMoney));

        assertThat(lottos).isNotEmpty();
        assertThat(lottos.size()).isEqualTo(buyLottoSize);
    }

    @ParameterizedTest(name = "LottoSeller에게 로또 판매금액[{arguments}]을 입력하면 에러를 반환한다")
    @ValueSource(longs = {-1, 0})
    void settingLottoPrice(long lottoPrice) {
        Exception exception = assertThrows(InvalidParameterException.class, () -> seller.setLottoPrice(lottoPrice));

        assertThat(exception).isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining("invalid lotto price");
    }

    @ParameterizedTest(name = "LottoSeller에게 돈 {arguments}으로 Lotto를 살 수 없다")
    @ValueSource(longs = {-1, 0})
    void emptyMoneyBuyLottoTest(long notEnoughMoney) {
        Wallet notEnoughWallet = new Wallet(notEnoughMoney);
        List<Lotto> lottos = seller.buyLotto(notEnoughWallet);

        assertThat(lottos).isEmpty();
    }
}