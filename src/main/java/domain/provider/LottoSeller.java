package domain.provider;

import domain.customer.Customer;
import domain.lotto.Lotto;
import domain.lotto.LottoCollection;
import domain.money.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * @author delf
 */
public class LottoSeller {

	private static final Money LOTTO_PRICE = new Money(1_000);
	private LottoGenerator lottoGenerator = new LottoGenerator(); // 현재는 고정

	public LottoCollection sellTo(Money money) {
		int nLotto = howManyLotto(money);
		return generateLottoCollection(nLotto);
	}

	private int howManyLotto(Money money) {
		return money.divide(LOTTO_PRICE).getAmount();
	}

	private LottoCollection generateLottoCollection(/* 로또 생성 전략 ,*/ int size) {
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			lottoList.add(lottoGenerator.generateLotto());
		}
		return new LottoCollection(lottoList);
	}
}
