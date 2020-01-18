public enum Rank {
	FIRST(6,  2000000000),
	SECOND(5,  1500000),
	THIRD(4, 50000),
	FOURTH(3, 5000);

	private int countOfMatch;
	private int prizeMoney;

	Rank(final int countOfMatch, final int prizeMoney) {
		this.countOfMatch = countOfMatch;
		this.prizeMoney = prizeMoney;
	}

	public static Rank valueOf(final int countOfMatch) {
		for (final Rank rank : Rank.values()) {
			if (rank.countOfMatch == countOfMatch) {
				return rank;
			}
		}

		throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

}
