package domain.lotto;

public interface Lotto {

    MatchingInfo getMatchingInfo(Lotto winningLotto, Lotto bonusLotto);
}
