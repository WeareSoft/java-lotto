package com.hee.domain.number;

import java.security.InvalidParameterException;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private int value;

    public LottoNumber(int value) {
        verifyRange(value);
        this.value = value;
    }

    private void verifyRange(int value) {
        if (MAX_VALUE < value || MIN_VALUE > value) {
            throw new InvalidParameterException("1 ~ 45 사이의 숫자가 아닙니다.");
        }
    }
//
//    public Integer getValue() {
//        return this.value;
//    }

    @Override
    public int compareTo(LottoNumber o) {
        LottoNumber target = (LottoNumber) o;
        if (target.value > this.value) {
            return -1;
        } else if (target.value < this.value) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
