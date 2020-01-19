package domain.lotto;

import domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private final static WinningLotto WINNING_LOTTO = new WinningLotto(
            new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))),
            LottoNumber.of(7)
    );

    @Test
    void noMatch() {
        final Lotto userLotto = generateLotto(8, 9, 10, 11, 12, 13, 14);
        assertThat(WINNING_LOTTO.match(userLotto)).isEqualTo(Rank.MISS);
    }


    @Test
    void matchThree() {
        final Lotto userLotto = generateLotto(1, 2, 3, 11, 12, 13);
        assertThat(WINNING_LOTTO.match(userLotto)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void matchFour() {
        final Lotto userLotto = generateLotto(1, 2, 3, 4, 12, 13);
        assertThat(WINNING_LOTTO.match(userLotto)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void matchFive() {
        final Lotto userLotto = generateLotto(1, 2, 3, 4, 5, 13);
        assertThat(WINNING_LOTTO.match(userLotto)).isEqualTo(Rank.THIRD);
    }

    @Test
    void matchSix() {
        final Lotto userLotto = generateLotto(1, 2, 3, 4, 5, 6);
        assertThat(WINNING_LOTTO.match(userLotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    void matchFiveAndBonus() {
        final Lotto userLotto = generateLotto(1, 2, 3, 4, 5, 7, 14);
        assertThat(WINNING_LOTTO.match(userLotto)).isEqualTo(Rank.SECOND);
    }


    private Lotto generateLotto(int... lottoNumbers) {
        return new Lotto(Arrays.stream(lottoNumbers).mapToObj(LottoNumber::of).collect(toList()));
    }

}
