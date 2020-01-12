package domain.customer;

import domain.lotto.LottoCollection;
import domain.money.Money;
import output.OutputView;

/**
 * @author delf
 */
public class Customer {
	private final static Money DEFAULT_MONEY = new Money(Integer.MAX_VALUE);

	private LottoCollection myLotto;

	public void buy(LottoCollection lottos) {
		this.myLotto = lottos;
	}

	public LottoCollection getMyLotto() {
		return myLotto;
	}

	public void printLotto(OutputView outputView) {
		outputView.printLotto(myLotto);
	}

	public void checkLotto() {

	}
}
