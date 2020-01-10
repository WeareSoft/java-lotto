package domain.actor.impl;

import domain.actor.LottoBuildable;
import domain.lotto.Lotto;
import domain.lotto.LottoValueable;
import domain.lotto.number.LottoOfNumber;
import domain.lotto.strategy.LottoValueBuildStrategy;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBuilder implements LottoBuildable {

    private LottoType lottoType = LottoType.NUMBER;

    public enum LottoType {
        NUMBER;

        public static Lotto build(LottoType type, List<LottoValueable> values) {
            if (type == LottoType.NUMBER) {
                return new LottoOfNumber(values);
            }

            throw new InvalidParameterException("not support lotto type");
        }
    }

    public void setLottoType(LottoType lottoType) {
        this.lottoType = lottoType;
    }

    public List<Lotto> build(int size, LottoValueBuildStrategy strategy) {
        return IntStream.range(0, size)
                .mapToObj((value) -> {
                    List<LottoValueable> values = strategy.buildLottoVaules();
                    return LottoType.build(lottoType, values);
                })
                .collect(Collectors.toList());
    }
}
