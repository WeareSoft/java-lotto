package domain.actor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.lotto.Lotto;
import fixture.LottoParameterExtension;
import fixture.LottoParameterExtension.MockLotto;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

@ExtendWith(LottoParameterExtension.class)
class LottoCheckerTest {

    private LottoChecker checker;

    @BeforeEach
    void setUp() {
        checker = new LottoChecker();
    }

    @Test
    @DisplayName("LottoChecker에게 해당 회차의 당첨 로또를 입력하고 확인할 수 있다")
    void settingWinningLotto(@MockLotto Lotto winningLotto) {
        checker.settingWinningLotto(winningLotto);

        assertThat(checker.isWinningLotto(winningLotto)).isTrue();
    }

    @ParameterizedTest(name = "잘못된 로또[{arguments}]로 Winning인지 검증하면 false를 반환한다")
    @NullSource
    void whenInvalidParameterisWinningLottoReturnFalse(Lotto invalidLotto, @MockLotto Lotto winningLotto) {
        checker.settingWinningLotto(winningLotto);

        assertThat(checker.isWinningLotto(invalidLotto)).isFalse();
    }

    @ParameterizedTest(name = "LottoCheck에게 잘못된 당첨 로또[{arguments}]를 입력하면 에러를 반환한다")
    @NullSource
    void whenInvalidWinningLottoinSettingWinningLotto(Lotto invalidLotto) {
        Exception exception = assertThrows(InvalidParameterException.class, () -> checker.settingWinningLotto(invalidLotto));

        assertThat(exception).isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining("invalid lotto");
    }

    @Test
    @DisplayName("LottoChecker에게 당첨이 아닌 로또는 false로 반환한다")
    void isWinningLotto(@MockLotto Lotto winningLotto, @MockLotto Lotto dummyLotto) {
        checker.settingWinningLotto(winningLotto);

        assertThat(checker.isWinningLotto(dummyLotto)).isFalse();
    }
}