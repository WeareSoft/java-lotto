package domain.pay;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest(name = "돈이 없는 경우[{arguments}] 없음을 확인할 수 있다")
    @ValueSource(longs = {-1, 0})
    void isEmptyTest(long notEnoughMoney) {
        Payable money = new Money(notEnoughMoney);

        assertThat(money.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("돈이 얼마나 있는지 정보를 얻을 수 있다")
    void test() {
        long amount = 3000;
        Payable money = new Money(amount);

        long holdingMoney = money.getMoney();

        assertThat(holdingMoney).isEqualTo(amount);
    }
}