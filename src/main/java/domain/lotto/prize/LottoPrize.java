package domain.lotto.prize;

import java.util.Objects;

public class LottoPrize implements Prizeable {

    private long matchCount;

    private long prize;

    public LottoPrize(long matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    @Override
    public Long getMatchCount() {
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPrize that = (LottoPrize) o;
        return matchCount == that.matchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount);
    }

    @Override
    public Long getPrize() {
        return prize;
    }
}
