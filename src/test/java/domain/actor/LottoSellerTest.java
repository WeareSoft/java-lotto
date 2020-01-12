package domain.actor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.actor.impl.LottoBuilder;
import domain.actor.impl.LottoSeller;
import domain.lotto.Lotto;
import domain.lotto.strategy.LottoValueBuildStrategy;
import domain.pay.Wallet;
import fixture.LottoParameterExtension;
import fixture.StrategryParameterExtension;
import fixture.StrategryParameterExtension.LottoBuildStrategy;
import fixture.StrategryParameterExtension.StrategyType;
import java.security.InvalidParameterException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith({LottoParameterExtension.class, StrategryParameterExtension.class})
class LottoSellerTest {

    private LottoSellable seller;

    @BeforeEach
    void setUp() {
        this.seller = new LottoSeller(new LottoBuilder(), 1000);
    }

    @ParameterizedTest(name = "LottoSeller에게 돈{arguments}을 주고 Lotto를 살 수 있다")
    @ValueSource(longs = {1000, 3000, 5000})
    void buyLottoTest(long enoughMoney, @LottoBuildStrategy(type = StrategyType.RANDOM) LottoValueBuildStrategy strategy) {
        final long lottoPrice = 1000L;
        final long buyLottoSize = enoughMoney / lottoPrice;
        seller.setLottoPrice(lottoPrice);

        List<Lotto> lottos = seller.buyLotto(new Wallet(enoughMoney), strategy);

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
    void emptyMoneyBuyLottoTest(long notEnoughMoney, @LottoBuildStrategy(type = StrategyType.RANDOM) LottoValueBuildStrategy strategy) {
        Wallet notEnoughWallet = new Wallet(notEnoughMoney);
        List<Lotto> lottos = seller.buyLotto(notEnoughWallet, strategy);

        assertThat(lottos).isEmpty();
    }

    @ParameterizedTest(name = "LottoSeller에게 잘못된 생성 방법을 주면 빈값을 반환한다")
    @NullSource
    void test4(LottoValueBuildStrategy strategy) {
        Wallet enoughWallet = new Wallet(10000);
        List<Lotto> lottos = seller.buyLotto(enoughWallet, strategy);

        assertThat(lottos).isEmpty();
    }
}