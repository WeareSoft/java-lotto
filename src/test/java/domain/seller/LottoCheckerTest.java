package domain.seller;

import static org.assertj.core.api.Assertions.assertThat;

import domain.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {

    private LottoChecker checker;

    @BeforeEach
    void setUp() {
        checker = new LottoChecker();
    }

    @Test
    @DisplayName("LottoChecker에게 해당 회차의 당첨 로또를 입력하고 확인할 수 있다")
    void settingWinningLotto() {
        Lotto winningLotto = new Lotto();
        checker.settingWinningLotto(winningLotto);

        assertThat(checker.isWinningLotto(winningLotto)).isTrue();
    }

    @Test
    @DisplayName("LottoChecker에게 당첨이 아닌 로또는 false로 반환한다")
    void isWinningLotto() {
        Lotto dummyLotto = new Lotto();
        Lotto winningLotto = new Lotto();
        checker.settingWinningLotto(winningLotto);

        assertThat(checker.isWinningLotto(dummyLotto)).isFalse();
    }
}