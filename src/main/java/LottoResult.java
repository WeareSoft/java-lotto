import java.util.HashMap;
import java.util.Map;

public class LottoResult {
	static final int THREE = 3;
	private static final int THREE_MATCH_PRIZE_MONEY = 5000;

	static final int FOUR = 4;
	private static final int FOURTH_MATCH_PRIZE_MONEY = 50000;

	static final int FIVE = 5;
	private static final int FIFTH_MATCH_PRIZE_MONEY = 1500000;

	static final int SIX = 6;
	private static final int SIXTH_MATCH_PRIZE_MONEY = 2000000000;

	private Map<Integer, Integer> matchCountMap;

	public LottoResult() {
		this.matchCountMap = new HashMap<>() {{
			put(THREE, 0);
			put(FOUR, 0);
			put(FIVE, 0);
			put(SIX, 0);
		}};
	}

	public void add(int matchCount) {
		if (!matchCountMap.keySet().contains(matchCount))
			return;
		matchCountMap.put(matchCount, matchCountMap.get(matchCount) + 1);
	}

	public int count(final int matchCount) {
		return matchCountMap.get(matchCount);
	}

	public int calculatePrizeMoney() {
		int sum = 0;
		sum += matchCountMap.get(THREE) * THREE_MATCH_PRIZE_MONEY
				+ matchCountMap.get(FOUR) * FOURTH_MATCH_PRIZE_MONEY
				+ matchCountMap.get(FIVE) * FIFTH_MATCH_PRIZE_MONEY
				+ matchCountMap.get(SIX) * SIXTH_MATCH_PRIZE_MONEY;
		return sum;
	}
}
