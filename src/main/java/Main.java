public class Main {
	private static final int LOTTO_NUMBER_SIZE = 6;

	public static void main(String[] args) {
		LottoGame game = new LottoGame();

		int money = InputView.askPurchasingAmount();
		ResultView.printTickets(game.buyTickets(money, new RandomNumberGenerator(LOTTO_NUMBER_SIZE)));

		WinningTicket winningTicket = new WinningTicket(LottoNumbers.of(InputView.askWinningNumbers()));
		LottoResult result = game.matchTickets(winningTicket);
		ResultView.printStatistics(result);
		ResultView.printRateOfRevenue(game.calculateRevenue(money, result));
	}
}
