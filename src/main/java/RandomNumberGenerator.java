import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;
	private static final int LOTTO_WINNING_NUMBERS_COUNT = 6;

	@Override
	public List<Integer> generate() {
		final List<Integer> randomNumbers = getRandomNumbers();
		Collections.sort(randomNumbers);
		return randomNumbers;
	}

	private List<Integer> getRandomNumbers() {
		final List<Integer> candidateLottoNumbers = generateRangeNumbers();
		Collections.shuffle(candidateLottoNumbers);
		return candidateLottoNumbers.subList(0, LOTTO_WINNING_NUMBERS_COUNT);
	}

	private List<Integer> generateRangeNumbers() {
		return IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
				.boxed()
				.collect(Collectors.toList());
	}
}
