import java.util.EnumMap;

public class LottoResult {
	private final EnumMap<Rank, Integer> rankCountMap;

	public LottoResult() {
		this.rankCountMap = new EnumMap<>(Rank.class);
		for (Rank rank : Rank.values()) {
			rankCountMap.put(rank, 0);
		}
	}

	public void add(final Rank rank) {
		rankCountMap.put(rank, rankCountMap.get(rank) + 1);
	}

	public int calculatePrizeMoney() {
		int sum = 0;
		for (Rank rank : rankCountMap.keySet()) {
			sum += rankCountMap.get(rank) * rank.getPrizeMoney();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Rank rank : rankCountMap.keySet()) {
			stringBuilder.append(rank.toString())
					.append(String.format(" - %d개", rankCountMap.get(rank)))
					.append("\n");
		}
		return stringBuilder.toString();
	}
}
