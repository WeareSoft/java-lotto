package input;

import domain.lotto.Lotto;
import domain.lotto.LottoNumber;
import domain.lotto.WinningLotto;
import domain.money.Money;

import java.util.Arrays;

/**
 * @author delf
 */
public class InputView {
	private static final String buyGuideText = "구입금액을 입력해 주세요.";
	private static final String winningGuideText = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String bonusNumberGuideText = "보너스 볼을 입력해 주세요.";

	public static Money inputMoney() {
		return buyMock(1400000);
	}

	private static Money buyMock(int n) {
		System.out.println(buyGuideText);
		return Money.of(n);
	}

	public static WinningLotto inputWinningLottoNumber() {
		return winningLottoMock();
	}

	private static WinningLotto winningLottoMock() {
		System.out.println(winningGuideText);
		Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
		System.out.println("> 입력함");

		System.out.println(bonusNumberGuideText);
		WinningLotto winningLotto = new WinningLotto(lotto, LottoNumber.of(7));
		System.out.println("> 입력함");

		System.out.println(" 입력 값: " + winningLotto + "\n");

		return winningLotto;
	}
}
