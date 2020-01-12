package domain.lotto;

import domain.Rank;

import java.util.List;

/**
 * @author delf
 */
public class Lotto {

	public static final int PICK_NUM = 6;
	private List<LottoNumber> lotto;

	public Lotto(List<LottoNumber> lotto) {
		this.lotto = lotto;
	}

	@Override
	public String toString() {
		return lotto.toString();
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
}
