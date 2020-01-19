import java.util.List;

public class Main {
	private static final int LOTTO_NUMBER_SIZE = 6;

	public static void main(String[] args) {
		LottoSeller seller = new LottoSeller(new RandomNumberGenerator(LOTTO_NUMBER_SIZE));

		int money = InputView.askPurchasingAmount();

		List<Ticket> tickets = seller.buyTickets(money);
		ResultView.printTickets(tickets);

		WinningTicket winningTicket = new WinningTicket(LottoNumbers.of(InputView.askWinningNumbers()));

		LottoGame game = new LottoGame(tickets);
		LottoResult result = game.matchTickets(winningTicket);
		ResultView.printStatistics(result);
		ResultView.printRateOfRevenue(game.calculateRevenue(money, result));
	}
}