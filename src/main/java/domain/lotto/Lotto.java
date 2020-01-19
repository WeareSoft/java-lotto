package domain.lotto;

import java.util.List;

/**
 * @author delf
 */
public class Lotto {

	public static final int PICK_NUM = 6;
	private List<LottoNumber> lotto;

	public Lotto(List<LottoNumber> lotto) {
		if (lotto.size() < PICK_NUM) {
			throw new IllegalArgumentException();
		}
		this.lotto = lotto;
	}

	public int getMatchCount(Lotto userLotto) {
		return (int) lotto.stream().filter(userLotto::contains).count();
	}

	public boolean contains(LottoNumber n) {
		return lotto.contains(n);
	}

	@Override
	public String toString() {
		return lotto.toString();
	}
}
