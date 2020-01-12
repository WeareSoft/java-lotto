package output;

import domain.lotto.LottoCollection;

/**
 * @author delf
 */
public class OutputView {

	public void printLotto(LottoCollection lottoCollection) {
		System.out.println(lottoCollection.size() + "개를 구매했습니다.");
		System.out.println(lottoCollection);
	}

	public void showWinningStatistics(Statistics statistics) {
		System.out.println("당첨 통계" + "\n" + "-------------");
		System.out.println(statistics);

	}
}
