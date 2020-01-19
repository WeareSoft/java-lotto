public class WinningTicket {
	private final Ticket ticket;

	public WinningTicket(final LottoNumbers numbers) {
		this.ticket = new Ticket(numbers);
	}

	public boolean contains(final LottoNumber lottoNumber) {
		return this.ticket.contains(lottoNumber);
	}
}
