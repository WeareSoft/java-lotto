import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private static final int PRICE = 1000;

	private List<Ticket> tickets;

	public LottoGame() {
		tickets = new ArrayList<>();
	}

	public List<Ticket> buyTickets(final int money, final NumberGenerator numberGenerator) {
		tickets = TicketFactory.create(money / PRICE, numberGenerator);
		return tickets;
	}

	public LottoResult matchTickets(final WinningTicket winningTicket) {
		LottoResult lottoResult = new LottoResult();
		for (Ticket ticket : tickets) {
			lottoResult.add(ticket.match(winningTicket));
		}

		return lottoResult;
	}

	public float calculateRevenue(final int money, final LottoResult lottoResult) {
		return (float) 100 * lottoResult.calculatePrizeMoney() / money;
	}
}
