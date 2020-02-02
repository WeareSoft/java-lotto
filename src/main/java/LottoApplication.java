import domain.lotto.Lotto;
import domain.lotto.LottoCollection;
import domain.lotto.LottoNumber;
import domain.lotto.WinningLotto;
import domain.money.Money;
import domain.provider.LottoSeller;
import input.InputView;
import output.OutputView;
import domain.LottoStatistics;

import java.util.Scanner;

/**
 * @author delf
 */
public class LottoApplication {
	public static void main(String[] args) {
		final Money lottoPrice = Money.of(1000);
		LottoSeller lottoSeller = new LottoSeller(lottoPrice);

		Money money = InputView.inputMoney();

		int manualCount = InputView.getManualCount();

		LottoCollection myLotto = lottoSeller.sellTo(money, manualCount);

		OutputView.printLotto(myLotto);

		WinningLotto winningLotto = InputView.inputWinningLottoNumber();

		LottoStatistics lottoStatistics = new LottoStatistics(winningLotto, myLotto, money);
		OutputView.showWinningStatistics(lottoStatistics);
	}
}
