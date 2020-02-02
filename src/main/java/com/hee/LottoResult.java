package com.hee;

import com.hee.domain.Prize;

import java.util.EnumMap;

public class LottoResult {

    private final EnumMap<Prize, Integer> matchedPrizes;

    public LottoResult() {
        this.matchedPrizes = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            matchedPrizes.put(prize, 0);
        }
    }

    public void updateResult(final Prize prize) {
        matchedPrizes.put(prize, matchedPrizes.get(prize) + 1);
    }

    public float calculateProfitRate(final LottoResult lottoResult, final int purchaseAmount) {
        return ((float) lottoResult.calculateTotalPrizes() / purchaseAmount) * 100;
    }

    public int calculateTotalPrizes() {
        return matchedPrizes.keySet()
                .stream()
                .map(prize -> matchedPrizes.get(prize) * prize.getPrizeMoney())
                .mapToInt(Integer::valueOf)
                .sum();
    }

    public EnumMap<Prize, Integer> getMatchedPrizes() {
        return this.matchedPrizes;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        matchedPrizes.keySet()
                .forEach(prize ->
                        stringBuilder.append(prize.getPrizeMoney() * matchedPrizes.get(prize)));
        return stringBuilder.toString();
    }

}
