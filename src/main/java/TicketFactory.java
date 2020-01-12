import java.util.ArrayList;
import java.util.List;

public class TicketFactory {
	public static List<Ticket> create(final int count, final NumberGenerator numberGenerator) {
		List<Ticket> tickets = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			tickets.add(new Ticket(LottoNumbers.of(numberGenerator.generate())));
		}
		return tickets;
	}
}
