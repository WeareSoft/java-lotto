import domain.Rank;
import domain.lotto.Lotto;
import domain.lotto.LottoCollection;
import domain.money.Money;
import domain.provider.LottoSeller;
import input.InputView;
import output.OutputView;
import output.Statistics;

import java.util.Map;

/**
 * @author delf
 */
public class LottoSimulator {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();

		LottoSeller lottoSeller = new LottoSeller();

		Money money = inputView.inputMoney();
		LottoCollection myLotto = lottoSeller.sellTo(money);

		outputView.printLotto(myLotto);

		Lotto winningLotto = inputView.inputWinningLottoNumber();

		Statistics statistics = new Statistics(getResult(winningLotto, myLotto), money);
		outputView.showWinningStatistics(statistics);
	}


	static Map<Rank, Integer> getResult(Lotto winningLotto, LottoCollection lottoCollection) {
		Map<Rank, Integer> counter = Rank.RANK_COUNTER();
		for (Lotto lotto : lottoCollection) {
			counter.merge(winningLotto.match(lotto), 1, Integer::sum);
		}
		return counter;
	}
}
