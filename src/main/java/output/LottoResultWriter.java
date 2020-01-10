package output;

import domain.actor.LottoPrizeable;
import domain.lotto.prize.Prizeable;
import java.util.List;
import java.util.Map;

public class LottoResultWriter {

    private static final String FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String TOTAL_FORMAT = "총 수익률은 %.1f입니다.";

    public static void writePrizeInfo(int money, LottoPrizeable prizer, List<Prizeable> buyerPrizeInfo) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<Long, Prizeable> prizeableMap = prizer.getAllPrizeInfo();
        long totalPrize = 0;
        for (Long matchCount : prizeableMap.keySet()) {
            Prizeable prizeinfo = prizeableMap.get(matchCount);
            int count = (int) buyerPrizeInfo.stream().filter(prizeinfo::equals).count();
            System.out.println(String.format(FORMAT, matchCount, prizeinfo.getPrize(), count));
            totalPrize += prizeinfo.getPrize() * count;
        }

        System.out.println(String.format(TOTAL_FORMAT, (totalPrize / (double) money) * 100));
    }
}
