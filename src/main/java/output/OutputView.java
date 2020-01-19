package output;

import domain.lotto.LottoCollection;
import domain.LottoStatistics;

/**
 * @author delf
 */
public class OutputView {

	public static void printLotto(LottoCollection lottoCollection) {
		System.out.println(lottoCollection.size() + "개를 구매했습니다.");
		lottoCollection.forEach(System.out::println);
	}

	public static void showWinningStatistics(LottoStatistics lottoStatistics) {
		System.out.println("당첨 통계" + "\n" + "-------------");
		lottoStatistics.forEach(rank -> System.out.println(
				String.format("- %s %s개", rank, lottoStatistics.getCount(rank)))
		);
		System.out.println(String.format("\n총 수익률은 %.2f%%입니다.", lottoStatistics.getRor()));
	}
}
