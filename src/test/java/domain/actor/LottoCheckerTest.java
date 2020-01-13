package domain.actor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.actor.impl.LottoChecker;
import domain.actor.impl.LottoPrizer;
import domain.lotto.Lotto;
import fixture.LottoParameterExtension;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

@ExtendWith(LottoParameterExtension.class)
class LottoCheckerTest {

    private LottoChecker checker;

    @BeforeEach
    void setUp() {
        checker = new LottoChecker(new LottoPrizer());
    }

    @ParameterizedTest(name = "LottoCheck에게 잘못된 당첨 로또[{arguments}]를 입력하면 에러를 반환한다")
    @NullSource
    void whenInvalidWinningLottoinSettingWinningLotto(Lotto invalidLotto) {
        Exception exception = assertThrows(InvalidParameterException.class, () -> checker.settingWinningLotto(invalidLotto));

        assertThat(exception).isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining("invalid lotto");
    }
}