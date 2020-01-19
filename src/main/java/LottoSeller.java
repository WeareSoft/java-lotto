import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
	private static final int PRICE = 1000;

	private final NumberGenerator numberGenerator;

	public LottoSeller(final NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public List<Ticket> buyTickets(final int money) {
		List<Ticket> tickets = new ArrayList<>();
		for (int i = 0; i < money / PRICE; i++) {
			tickets.add(new Ticket(LottoNumbers.of(numberGenerator.generate())));
		}
		return tickets;
	}
}
