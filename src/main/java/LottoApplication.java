import domain.actor.LottoSellable;
import domain.actor.LottoSeller;
import domain.lotto.Lotto;
import domain.lotto.LottoBuilder;
import domain.lotto.strategy.RandomStrategy;
import domain.wallet.Wallet;
import input.SellerReader;
import java.util.List;
import output.LottoWriter;

public class LottoApplication {

    public static void main(String[] args) {

        int money = SellerReader.getBuyMoney();

        LottoSellable seller = new LottoSeller(new LottoBuilder(), 1000);
        List<Lotto> lottos = seller.buyLotto(new Wallet(money), new RandomStrategy());

        LottoWriter.writeLottos(lottos);

    }
}
