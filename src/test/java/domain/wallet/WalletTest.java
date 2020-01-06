package domain.wallet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WalletTest {

    @Test
    @DisplayName("지갑에 돈이 없는 경우 빈 경우를 확인할 수 있다")
    void isEmptyTest() {
        Wallet wallet = new Wallet();

        assertThat(wallet.isEmptyWallet()).isTrue();
    }
}