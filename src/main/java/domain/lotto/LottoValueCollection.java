package domain.lotto;

import java.util.List;

public interface LottoValueCollection {

    List<LottoValueable> getLottoValues();

    long getMatchingSize(LottoValueCollection values);
}
