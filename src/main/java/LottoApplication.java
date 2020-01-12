import domain.lotto.Lotto;
import domain.lotto.LottoCollection;
import domain.money.Money;
import domain.provider.LottoSeller;
import input.InputView;
import output.OutputView;
import output.Statistics;

/**
 * @author delf
 */
public class LottoApplication {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();

		LottoSeller lottoSeller = new LottoSeller();

		Money money = inputView.inputMoney();
		LottoCollection myLotto = lottoSeller.sellTo(money);

		outputView.printLotto(myLotto);

		Lotto winningLotto = inputView.inputWinningLottoNumber();

		Statistics statistics = new Statistics(winningLotto, myLotto, money);
		outputView.showWinningStatistics(statistics);
	}
}
