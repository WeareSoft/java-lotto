package com.hee.view;

import com.hee.LottoResult;
import com.hee.domain.Ticket;

import java.util.List;

public class ResultView {

    private final static String NUMBER_OF_TICKETS_MESSAGE = "개를 구매했습니다.";
    private final static String RESULT = "\n당첨 통계\n--------";
    private static final String RESULT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String YIELD_FORMAT = "총 수익률은 %.1f%% 입니다.";

    public static void printTickets(final List<Ticket> tickets) {
        System.out.println(tickets.size() + NUMBER_OF_TICKETS_MESSAGE);
        tickets.forEach(ticket -> System.out.println(ticket.toString()));
    }

    public static void printResult(final LottoResult result) {
        System.out.println(RESULT);
        result.getMatchedPrizes()
                .keySet()
                .forEach(prize -> System.out.println(String.format(RESULT_FORMAT,
                                prize.getNumOfMatchingNumbers(),
                                prize.getPrizeMoney(),
                                result.getMatchedPrizes().get(prize))));
    }

    public static void printProfitRate(final LottoResult result, final int purchaseAmount) {
        System.out.println(String.format(YIELD_FORMAT, result.calculateProfitRate(result, purchaseAmount))); // 수익률
    }
}
