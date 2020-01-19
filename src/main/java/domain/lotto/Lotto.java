package domain.lotto;

public interface Lotto {

    long getMatching(Lotto compareLotto);

    MatchingInfo getMatchingInfo(Lotto winningLotto, Lotto bonusLotto);
}
