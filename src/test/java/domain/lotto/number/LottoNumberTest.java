package domain.lotto.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호는 최대값을 넘어서면 에러를 반환한다")
    public void whenOverLottoMaxValueReturnError() {
        int overLottoMaxValue = LottoNumber.MAX_VALUE + 1;

        Exception exception = assertThrows(InvalidParameterException.class, () -> new LottoNumber(overLottoMaxValue));

        assertThat(exception.getMessage()).isEqualTo("invalid lotto value");
    }

    @Test
    @DisplayName("로또 번호는 최소값보다 작으면 에러를 반환한다")
    public void whenLessLottoMinValueReturnError() {
        int lessLottoMinValue = LottoNumber.MIN_VALUE - 1;

        Exception exception = assertThrows(InvalidParameterException.class, () -> new LottoNumber(lessLottoMinValue));

        assertThat(exception.getMessage()).isEqualTo("invalid lotto value");
    }
}