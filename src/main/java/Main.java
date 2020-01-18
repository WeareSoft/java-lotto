public class Main {
	public static void main(String[] args) {
		LottoGame game = new LottoGame();

		int money = InputView.askPurchasingAmount();
		ResultView.printTickets(game.buyTickets(money, new RandomNumberGenerator()));

		WinningTicket winningTicket = new WinningTicket(LottoNumbers.of(InputView.askWinningNumbers()));
		LottoResult result = game.matchTickets(winningTicket);
		ResultView.printStatistics(result);
		ResultView.printRateOfRevenue(game.calculateRevenue(money, result));
	}
}
