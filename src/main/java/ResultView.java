import java.util.List;

public class ResultView {
	public static void printTickets(final List<Ticket> tickets) {
		tickets.forEach(ticket -> System.out.println(ticket.toString()));
	}

	public static void printStatistics(final LottoResult lottoResult) {
		System.out.println("당첨 통계");
		System.out.println("-------------");

		System.out.println(String.format("3개 일치 (5000원)- %d개", lottoResult.count(LottoResult.THREE)));
		System.out.println(String.format("4개 일치 (50000원)- %d개", lottoResult.count(LottoResult.FOUR)));
		System.out.println(String.format("5개 일치 (1500000원)- %d개", lottoResult.count(LottoResult.FIVE)));
		System.out.println(String.format("6개 일치 (2000000000원)- %d개", lottoResult.count(LottoResult.SIX)));
	}

	public static void printRateOfRevenue(final float revenue) {
		System.out.println(String.format("총 수익률은 %.1f%%입니다.", revenue));
	}
}
