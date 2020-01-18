import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {
	private final int size;

	public RandomNumberGenerator(final int size) {
		this.size = size;
	}

	@Override
	public List<Integer> generate() {
		final List<Integer> candidateLottoNumbers = generateRangeNumbers();
		Collections.shuffle(candidateLottoNumbers);
		return candidateLottoNumbers.stream()
				.limit(size)
				.sorted()
				.collect(Collectors.toList());
	}

	private List<Integer> generateRangeNumbers() {
		return IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
				.boxed()
				.collect(Collectors.toList());
	}
}
