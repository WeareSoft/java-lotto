import java.util.EnumMap;

public class LottoResult {
	private final EnumMap<Rank, Integer> rankCountMap;

	public LottoResult() {
		this.rankCountMap = new EnumMap<>(Rank.class);
		for (Rank rank : Rank.values()) {
			rankCountMap.put(rank, 0);
		}
	}

	public void add(final int matchCount) {
		rankCountMap.put(Rank.valueOf(matchCount), rankCountMap.get(Rank.valueOf(matchCount)) + 1);
	}

	public int count(final int matchCount) {
		return rankCountMap.get(Rank.valueOf(matchCount));
	}

	public int calculatePrizeMoney() {
		int sum = 0;
		for (Rank rank : Rank.values()) {
			sum += rankCountMap.get(rank) * rank.getPrizeMoney();
		}
		return sum;
	}
}
