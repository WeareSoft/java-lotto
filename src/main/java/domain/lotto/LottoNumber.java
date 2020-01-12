package domain.lotto;

import java.util.Map;

/**
 * @author delf
 */
public class LottoNumber {
	public static final int MIN = 1;
	public static final int MAX = 45;

	private int number;

	public static LottoNumber of(int number) {
		return new LottoNumber(number);
	}
	private LottoNumber(int number) {
		if (number < MIN || number > MAX) {
			throw new IllegalArgumentException();
		}
		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LottoNumber that = (LottoNumber) o;

		return number == that.number;
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
