package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author delf
 */
public enum Rank {

	FIRST(6, 2_000_000_000), // 1등
	SECOND(5, 30_000_000), // 2등
	THIRD(5, 1_500_000), // 3등
	FOURTH(4, 50_000), // 4등
	FIFTH(3, 5_000), // 5등
	MISS(0, 0);

	private static final int WINNING_MIN_COUNT = 3;

	private int countOfMatch;
	private int winningMoney;

	Rank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public static Rank valueOf(int countOfMatch, boolean matchBonus) {
		if (countOfMatch < WINNING_MIN_COUNT) {
			return MISS;
		}

		if (SECOND.matchCount(countOfMatch) && matchBonus) {
			return SECOND;
		}

		for (Rank rank : values()) {
			if (rank.matchCount(countOfMatch) && rank != SECOND) {
				return rank;
			}
		}

		throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
	}

	public int getProfit(int n) {
		return winningMoney * n;
	}

	private boolean matchCount(int countOfMatch) {
		return this.countOfMatch == countOfMatch;
	}

	public static Map<Rank, Integer> RANK_COUNTER() {
		Map<Rank, Integer> map = new HashMap<>();
		for(Rank rank : Rank.values()) {
			map.put(rank, 0);
		}
		return map;
	}

	@Override
	public String toString() {
		String note = "";
		if (this == Rank.SECOND) {
			note = ", 보너스볼 일치";
		}
		return String.format("%d개 일치%s (%,d원)", countOfMatch, note, winningMoney);
	}
}
