public enum Rank {
	FIRST(6, 0, 2000000000),
	SECOND(5, 1,  30000000),
	THIRD(5, 0, 1500000),
	FOURTH(4, 0, 50000),
	FIFTH(3, 0, 5000);

	private int countOfMatch;
	private int countOfBonusMatch;
	private int prizeMoney;

	Rank(final int countOfMatch, final int countOfBonusMatch, final int prizeMoney) {
		this.countOfMatch = countOfMatch;
		this.countOfBonusMatch = countOfBonusMatch;
		this.prizeMoney = prizeMoney;
	}

	public static Rank valueOf(final int countOfMatch, final int countOfBonusMatch) {
		for (final Rank rank : Rank.values()) {
			if (rank.countOfMatch == countOfMatch && rank.countOfBonusMatch == countOfBonusMatch) {
				return rank;
			}
		}

		throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

}
