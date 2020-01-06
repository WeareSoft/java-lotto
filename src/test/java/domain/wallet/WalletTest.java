package domain.wallet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WalletTest {

    @ParameterizedTest(name = "지갑에 돈이 없는 경우[{arguments}] 지갑이 비어있음을 확인할 수 있다")
    @ValueSource(longs = {-1, 0})
    void isEmptyTest(long notEnoughMoney) {
        Wallet wallet = new Wallet(notEnoughMoney);

        assertThat(wallet.isEmptyWallet()).isTrue();
    }
}