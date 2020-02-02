package com.hee.strategy;

import com.hee.domain.number.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface GenerationStrategy {
    public List<LottoNumber> generateNumbers();
}
