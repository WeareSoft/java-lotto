package com.hee.strategy;

import com.hee.domain.number.LottoNumber;
import com.hee.domain.number.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomGenerationStrategy implements GenerationStrategy {

    private static final int LOTTO_NUMBER_SIZE = 6;

    @Override
    public List<LottoNumber> generateNumbers() {
        List<LottoNumber> numbers = LottoNumbers.of(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                                                .getLottoNumbers();
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }

}
