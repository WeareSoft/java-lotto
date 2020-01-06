package domain.seller;

import domain.lotto.Lotto;
import domain.wallet.Wallet;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoSeller {

    public List<Lotto> buyLotto(Wallet wallet) {
        if (wallet.isEmptyWallet()) {
            return Collections.emptyList();
        }
 
        return Arrays.asList(new Lotto());
    }
}