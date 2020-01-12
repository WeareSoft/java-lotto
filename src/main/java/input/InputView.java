package input;

import domain.lotto.Lotto;
import domain.lotto.LottoNumber;
import domain.money.Money;

import java.util.Arrays;

/**
 * @author delf
 */
public class InputView {
	private static final String buyGuideText = "구입금액을 입력해 주세요.";
	private static final String winningGuideText = "지난 주 당첨 번호를 입력해 주세요.";

	public Money inputMoney() {
		return buyMock(1400000);
	}

	private Money buyMock(int n) {
		System.out.println(buyGuideText);
		return new Money(n);
	}

	public Lotto inputWinningLottoNumber() {
		return winningLottoMock();
	}

	private Lotto winningLottoMock() {
		System.out.println(winningGuideText);
		Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
		System.out.println(lotto);

		return lotto;
	}

}
