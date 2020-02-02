package com.hee.domain;

import com.hee.domain.number.LottoNumber;
import com.hee.domain.number.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ticket {

    private static final String DELIMITER_OF_LOTTO_NUMBER = ", ";
    private LottoNumbers lottoNumbers;

    public Ticket(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public Ticket(final String lottoNumbers) {
        List<Integer> winningNumbers = toIntList(lottoNumbers);
        this.lottoNumbers = LottoNumbers.of(winningNumbers);
    }

    private static List<Integer> toIntList(final String input) {
        return Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int matchedCount(final Ticket winningTicket) {
        return (int) this.lottoNumbers.getLottoNumbers()
                .stream()
                .filter(winningTicket::contains).count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return "[" +
                lottoNumbers.getLottoNumbers()
                        .stream()
                        .map(LottoNumber::toString)
                        .collect(Collectors.joining(DELIMITER_OF_LOTTO_NUMBER)) +
                "]";
    }
}
