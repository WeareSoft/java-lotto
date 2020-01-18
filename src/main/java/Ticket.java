import java.util.stream.Collectors;

public class Ticket {
	private final LottoNumbers numbers;

	public Ticket(final LottoNumbers numbers) {
		this.numbers = numbers;
	}

	public int matchCount(final WinningTicket winningTicket) {
		return Math.toIntExact(numbers.toList().stream().filter(winningTicket::contains).count());
	}

	public int matchCount(final LottoNumber lottoNumber) {
		if (this.contains(lottoNumber)) return 1;
		else return 0;
	}

	public boolean contains(final LottoNumber lottoNumber) {
		return this.numbers.toList().contains(lottoNumber);
	}

	public String toString() {
		return numbers.toList().stream()
				.map(lottoNumber -> String.valueOf(lottoNumber.toInt()))
				.collect(Collectors.joining(", "));
	}
}
