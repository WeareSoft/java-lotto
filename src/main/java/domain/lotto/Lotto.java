package domain.lotto;

import java.util.List;

/**
 * @author delf
 */
public class Lotto {

	private static final int PICK_NUM = 6;
	private List<LottoNumber> lotto;

	public Lotto(List<LottoNumber> lotto) {
		if (lotto.size() < PICK_NUM) {
			throw new IllegalArgumentException();
		}
		this.lotto = lotto;
	}

	public Rank match(Lotto userLotto) {
		int matchCount = getMatchCount(userLotto);
		return Rank.valueOf(matchCount);
	}

	private int getMatchCount(Lotto userLotto) {
		int count = 0;
		for (LottoNumber n : this.lotto) {
			count += userLotto.contains(n) ? 1 : 0;
		}
		return count;
	}

	private boolean contains(LottoNumber n) {
		return lotto.contains(n);
	}

	@Override
	public String toString() {
		return lotto.toString();
	}

}
