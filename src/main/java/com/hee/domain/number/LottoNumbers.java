package com.hee.domain.number;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private List<LottoNumber> values;

    public static LottoNumbers of(final int from, final int to) {
        return new LottoNumbers(from, to);
    }

    public static LottoNumbers of(final List<Integer> values) {
        return new LottoNumbers(values.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    private LottoNumbers(final int from, final int to) {
        this.values = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            values.add(new LottoNumber(i));
        }
    }

    public LottoNumbers(final List<LottoNumber> values) {
        this.values = values;
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.values.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return values;
    }
}
