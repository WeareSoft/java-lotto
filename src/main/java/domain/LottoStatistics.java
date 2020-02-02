package domain;

import domain.lotto.Lotto;
import domain.lotto.LottoCollection;
import domain.lotto.WinningLotto;
import domain.money.Money;

import java.util.Iterator;
import java.util.Map;

/**
 * @author delf
 */
public class LottoStatistics implements Iterable<Rank> {
	private Map<Rank, Integer> counter;
	private Money invest;

	public LottoStatistics(WinningLotto winningLotto, LottoCollection lottoCollection, Money money) {
		this.counter = getCounter(winningLotto, lottoCollection);
		this.invest = money;
	}

	public float getRor() {
		int sum = 0;
		for (Rank rank : counter.keySet()) {
			sum += rank.getProfit(counter.get(rank));
		}

		return (float) sum / invest.getAmount();
	}

	private Map<Rank, Integer> getCounter(WinningLotto winningLotto, LottoCollection lottoCollection) {
		Map<Rank, Integer> counter = Rank.RANK_COUNTER();
		for (Lotto lotto : lottoCollection) {
			counter.merge(winningLotto.match(lotto), 1, Integer::sum);
		}
		return counter;
	}

	@Override
	public Iterator<Rank> iterator() {
		return counter.keySet().iterator();
	}

	public int getCount(Rank rank) {
		return counter.get(rank);
	}
}
