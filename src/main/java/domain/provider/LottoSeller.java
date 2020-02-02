package domain.provider;

import domain.lotto.Lotto;
import domain.lotto.LottoCollection;
import domain.lotto.streragy.LottoAutoGenerateStrategy;
import domain.lotto.streragy.LottoGenerateStrategy;
import domain.money.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * @author delf
 */
public class LottoSeller {

	private  Money lotto;

	public LottoSeller(Money lottoPrice) {
		this.lotto = lottoPrice;
	}

	public LottoCollection sellTo(Money money) {
		int buyLottoSize = getCountOfLotto(money);
		return generateLottoCollection(new LottoAutoGenerateStrategy(), buyLottoSize);
	}

	private int getCountOfLotto(Money money) {
		return Money.of(money).getAmount() / lotto.getAmount();
	}

	private LottoCollection generateLottoCollection(LottoGenerateStrategy strategy, int size) {
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			lottoList.add(strategy.generateLotto());
		}
		return new LottoCollection(lottoList);
	}
}
