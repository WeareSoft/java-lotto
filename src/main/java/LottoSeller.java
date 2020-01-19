import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
	public static final int UNIT_PRICE = 1000;

	private final NumberGenerator numberGenerator;

	public LottoSeller(final NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public List<Ticket> buyTickets(final int money) {
		if (money < UNIT_PRICE) throw new IllegalArgumentException(UNIT_PRICE + "원 이상 구매해야 합니다");

		List<Ticket> tickets = new ArrayList<>();
		for (int i = 0; i < money / UNIT_PRICE; i++) {
			tickets.add(new Ticket(LottoNumbers.of(numberGenerator.generate())));
		}
		return tickets;
	}
}
