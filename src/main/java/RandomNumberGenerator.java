import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {
	private static final int LOTTO_NUMBERS_COUNT = 6;

	@Override
	public List<Integer> generate() {
		final List<Integer> randomNumbers = getRandomNumbers();
		Collections.sort(randomNumbers);
		return randomNumbers;
	}

	private List<Integer> getRandomNumbers() {
		final List<Integer> candidateLottoNumbers = generateRangeNumbers();
		Collections.shuffle(candidateLottoNumbers);
		return candidateLottoNumbers.subList(0, LOTTO_NUMBERS_COUNT);
	}

	private List<Integer> generateRangeNumbers() {
		return IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
				.boxed()
				.collect(Collectors.toList());
	}
}
