package com.hee.view;

import com.hee.LottoResult;
import com.hee.domain.Prize;
import com.hee.domain.Ticket;

import java.util.List;

public class ResultView {

    private final static String NUMBER_OF_TICKETS_MESSAGE = "개를 구매했습니다.";
    private final static String RESULT = "\n당첨 통계\n--------\n";
    private static final String RESULT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String RESULT_FORMAT_OF_SECOND_PRIZE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final String YIELD_FORMAT = "총 수익률은 %.1f%% 입니다.";

    public static void printTickets(final List<Ticket> tickets) {
        System.out.println(tickets.size() + NUMBER_OF_TICKETS_MESSAGE);
        tickets.forEach(ticket -> System.out.println(ticket.toString()));
    }

    public static void printResult(final LottoResult result) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RESULT);
        result.getMatchedPrizes().keySet()
                .forEach(prize -> {
                    String format = RESULT_FORMAT;
                    if (prize.same(Prize.SECOND)) {
                        format = RESULT_FORMAT_OF_SECOND_PRIZE;
                    }
                    stringBuilder
                            .append(String.format(format,
                                    prize.getNumOfMatchingNumbers(),
                                    prize.getPrizeMoney(),
                                    result.getMatchedPrizes().get(prize)))
                            .append("\n");
                });
        System.out.println(stringBuilder.toString());
    }

    public static void printProfitRate(final LottoResult result, final int purchaseAmount) {
        System.out.println(String.format(YIELD_FORMAT, result.calculateProfitRate(result, purchaseAmount))); // 수익률
    }
}
