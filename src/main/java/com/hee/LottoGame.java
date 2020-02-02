package com.hee;

import com.hee.domain.Prize;
import com.hee.domain.Ticket;
import com.hee.domain.number.LottoNumber;
import com.hee.strategy.GenerationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private static final int PRICE_OF_ONE_TICKET = 1000;

    private List<Ticket> tickets;

    public LottoGame() {
        tickets = new ArrayList<>();
    }

    public List<Ticket> buyTickets(final int purchaseAmount, final GenerationStrategy strategy) {
        int numberOfTickets = purchaseAmount / PRICE_OF_ONE_TICKET;
        this.tickets = IntStream.range(0, numberOfTickets)
                    .mapToObj(index -> new Ticket(strategy.generateNumbers()))
                    .collect(Collectors.toList());
        return this.tickets;
    }

    public LottoResult play(final String winningNumbersOfLastWeek, final LottoNumber bonusNumber) {
        Ticket winningTicket = new Ticket(winningNumbersOfLastWeek);
        LottoResult result = new LottoResult();
        this.tickets.forEach(ticket ->
                result.updateResult(Prize.valueOf(ticket.matchedCount(winningTicket), ticket.contains(bonusNumber))));
        return result;
    }
}
