package domain.lotto;

public class MatchingInfo {

    private long winningMatchCount;
    private long bonusMatchCount;

    public MatchingInfo(long winningMatchCount, long bonusMatchCount) {
        this.winningMatchCount = winningMatchCount;
        this.bonusMatchCount = bonusMatchCount;
    }

    public boolean isMatch(int winningCount, int bonusCount) {
        return winningCount == winningMatchCount && bonusCount == bonusMatchCount;
    }

    public boolean isMatch(int winningCount) {
        return winningCount == winningMatchCount;
    }
}
