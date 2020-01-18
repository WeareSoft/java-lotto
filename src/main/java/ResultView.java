import java.util.List;

public class ResultView {
	public static void printLottoCount(final int count) {
		System.out.println(String.format("%d개를 구입했습니다.", count));
	}

	public static void printTickets(final List<Ticket> tickets) {
		tickets.forEach(ticket -> System.out.println(ticket.toString()));
	}

	public static void printStatistics(final LottoResult lottoResult) {
		System.out.println("당첨 통계");
		System.out.println("-------------");
		System.out.println(lottoResult.toString());
	}

	public static void printRateOfRevenue(final float revenue) {
		System.out.println(String.format("총 수익률은 %.1f%%입니다.", revenue));
	}
}
