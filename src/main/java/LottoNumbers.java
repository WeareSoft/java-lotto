import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
	private final List<LottoNumber> numbers;

	public static LottoNumbers of(final String numbers) {
		return new LottoNumbers(Arrays.stream(numbers.split(", "))
				.map(Integer::parseInt)
				.map(LottoNumber::of)
				.collect(Collectors.toList()));
	}

	public static LottoNumbers of(final List<Integer> numbers) {
		return new LottoNumbers(numbers.stream().map(LottoNumber::of).collect(Collectors.toList()));
	}

	public LottoNumbers(final List<LottoNumber> numbers) {
		this.numbers = numbers;
	}

	public List<LottoNumber> toList() {
		return numbers;
	}
}
