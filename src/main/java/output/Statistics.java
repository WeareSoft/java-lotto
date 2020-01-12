package output;

import domain.lotto.Rank;
import domain.lotto.Lotto;
import domain.lotto.LottoCollection;
import domain.money.Money;

import java.util.Map;

/**
 * @author delf
 */
public class Statistics {
	private Map<Rank, Integer> counter;
	private float rateOfReturn;

	public Statistics(Lotto winningLotto, LottoCollection lottoCollection, Money money) {
		this.counter = getCounter(winningLotto, lottoCollection);
		this.rateOfReturn = calcRor() / money.getAmount();
	}

	private float calcRor() {
		int sum = 0;
		for (Rank rank : counter.keySet()) {
			sum += rank.getProfit(counter.get(rank));
		}
		return sum / counter.size();
	}

	private final static Rank[] PRINT_ORDER_RANK = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, /*Rank.SECOND, */Rank.FIRST};

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Rank rank : PRINT_ORDER_RANK) {
			sb.append(rank).append(" - ").append(counter.get(rank)).append("개\n");
		}

		return String.format("%s\n총 수익률은 %.1f%%입니다.", sb, rateOfReturn);
	}

	private Map<Rank, Integer> getCounter(Lotto winningLotto, LottoCollection lottoCollection) {
		Map<Rank, Integer> counter = Rank.RANK_COUNTER();
		for (Lotto lotto : lottoCollection) {
			counter.merge(winningLotto.match(lotto), 1, Integer::sum);
		}
		return counter;
	}
}
