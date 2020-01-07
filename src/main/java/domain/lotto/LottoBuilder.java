package domain.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBuilder {

    private int size;

    public LottoBuilder size(int size) {
        this.size = size;
        return this;
    }

    public List<Lotto> build() {
        return IntStream.range(0, size)
                .mapToObj((value) -> new NumberLotto())
                .collect(Collectors.toList());
    }
}
