public enum Rank {
	FIRST(6, false, 2000000000),
	SECOND(5, true,  30000000),
	THIRD(5, false, 1500000),
	FOURTH(4, false, 50000),
	FIFTH(3, false, 5000);

	private int countOfMatch;
	private boolean isBonusMatch;
	private int prizeMoney;

	Rank(final int countOfMatch, final boolean isBonusMatch, final int prizeMoney) {
		this.countOfMatch = countOfMatch;
		this.isBonusMatch = isBonusMatch;
		this.prizeMoney = prizeMoney;
	}

	public static Rank valueOf(final int countOfMatch, final boolean isBonusMatch) {
		for (final Rank rank : Rank.values()) {
			if (rank.countOfMatch == countOfMatch && rank.isBonusMatch == isBonusMatch) {
				return rank;
			}
		}

		throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}
}
