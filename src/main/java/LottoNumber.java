import java.util.Objects;

public class LottoNumber {
	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 45;

	private final int value;

	public static LottoNumber of(final int number) {
		return new LottoNumber(number);
	}

	public LottoNumber(final int value) {
		if (value < MIN_VALUE || value > MAX_VALUE) {
			throw new IllegalArgumentException("로또 번호는 " + MIN_VALUE + "이상 " + MAX_VALUE + "이하 이어야 합니다.");
		}
		this.value = value;
	}

	public int toInt() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LottoNumber)) return false;
		LottoNumber that = (LottoNumber) o;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
