package domain.seller;

import domain.lotto.Lotto;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoSeller {

    public List<Lotto> buyLotto(long money) {
        if (money <= 0L) {
            return Collections.emptyList();
        }

        return Arrays.asList(new Lotto());
    }
}