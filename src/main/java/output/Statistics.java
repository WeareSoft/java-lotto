package output;

import domain.Rank;
import domain.money.Money;

import java.util.Map;

/**
 * @author delf
 */
public class Statistics {
	private Map<Rank, Integer> ranks;
	private float rateOfReturn;

	public Statistics(Map<Rank, Integer> ranks, Money money) {
		this.ranks = ranks;
		this.rateOfReturn = calcRor() / money.getAmount();
	}

	private float calcRor() {
		int sum = 0;
		for (Rank rank : ranks.keySet()) {
			sum += rank.getProfit(ranks.get(rank));
		}
		return sum / ranks.size();
	}

	private final static Rank[] PRINT_ORDER_RANK = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, /*Rank.SECOND, */Rank.FIRST};

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Rank rank : PRINT_ORDER_RANK) {
			sb.append(rank).append(" - ").append(ranks.get(rank)).append("개\n");
		}

		return String.format("%s\n총 수익률은 %.1f%%입니다.", sb, rateOfReturn);
	}
}
