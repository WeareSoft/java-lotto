import java.util.List;

public class LottoGame {
	private final List<Ticket> tickets;

	public LottoGame(final List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public LottoResult matchTickets(final WinningTicket winningTicket) {
		LottoResult lottoResult = new LottoResult();
		for (Ticket ticket : tickets) {
			lottoResult.add(Rank.valueOf(ticket.match(winningTicket)));
		}

		return lottoResult;
	}

	public float calculateRevenue(final int money, final LottoResult lottoResult) {
		return (float) 100 * lottoResult.calculatePrizeMoney() / money;
	}
}
