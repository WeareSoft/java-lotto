package com.hee.domain;

import java.util.Arrays;

public enum Prize {

    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5,  1500000),
    SECOND(5,  30000000),
    FIRST(6,  2000000000);

    private int numOfMatchingNumbers;
    private int prizeMoney;

    Prize(final int numOfMatchingNumbers, final int prizeMoney) {
        this.numOfMatchingNumbers = numOfMatchingNumbers;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(final int numOfMatchingNumbers, final boolean containBonusNumber) {
        if (numOfMatchingNumbers == Prize.SECOND.numOfMatchingNumbers && containBonusNumber) {
            return Prize.SECOND;
        }
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.numOfMatchingNumbers == numOfMatchingNumbers)
                .findFirst()
                .orElse(Prize.NONE);
    }

    public boolean same(final Prize prize) {
        return this.equals(prize);
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getNumOfMatchingNumbers() {
        return this.numOfMatchingNumbers;
    }
}
