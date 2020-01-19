package output;

import domain.actor.LottoPrizeable;
import domain.lotto.prize.Prizeable;
import java.util.List;

public class LottoResultWriter {

    private static final String PRIZE_FORMAT = " (%d원)";
    private static final String MATCH_FORMAT = " (%d원)";
    private static final String TOTAL_FORMAT = "총 수익률은 %.1f입니다.";

    public static void writePrizeInfo(int money, LottoPrizeable prizer, List<Prizeable> buyerPrizeInfo) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        long totalPrize = 0;

        for (Prizeable prizeable : prizer.getAllPrizeInfo()) {
            int count = (int) buyerPrizeInfo.stream().filter(prizeable::equals).count();

            System.out.print(prizeable.toString());
            System.out.print(String.format(PRIZE_FORMAT, prizeable.getPrize()));
            System.out.print(String.format(MATCH_FORMAT, count));
            System.out.println();
            totalPrize += prizeable.getPrize() * count;
        }

        System.out.println(String.format(TOTAL_FORMAT, (totalPrize / (double) money) * 100));
    }
}
