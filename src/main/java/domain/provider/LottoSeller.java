package domain.provider;

import domain.lotto.Lotto;
import domain.lotto.LottoCollection;
import domain.money.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * @author delf
 */
public class LottoSeller {

	private  Money lotto;
	private LottoGenerator lottoGenerator = new LottoGenerator(); // 현재는 고정

	public LottoSeller(Money lottoPrice) {
		this.lotto = lottoPrice;
	}

	public LottoCollection sellTo(Money money) {
		int buyLottoSize = getCountOfLotto(money);
		return generateLottoCollection(buyLottoSize);
	}

	private int getCountOfLotto(Money money) {
		return Money.of(money).getAmount() / lotto.getAmount();
	}

	private LottoCollection generateLottoCollection(/* 로또 생성 전략 ,*/ int size) {
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			lottoList.add(lottoGenerator.generateLotto());
		}
		return new LottoCollection(lottoList);
	}
}
