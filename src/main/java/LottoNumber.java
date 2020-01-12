import java.util.Objects;

public class LottoNumber {
	private final int number;

	public static LottoNumber of(final int number) {
		return new LottoNumber(number);
	}

	public LottoNumber(final int number) {
		if (number < 1 || number > 45) {
			throw new IllegalArgumentException();
		}
		this.number = number;
	}

	public int toInt() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LottoNumber)) return false;
		LottoNumber that = (LottoNumber) o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
