import domain.actor.LottoBuildable;
import domain.actor.LottoMatchable;
import domain.actor.LottoPrizeable;
import domain.actor.LottoSellable;
import domain.actor.impl.LottoBuilder;
import domain.actor.impl.LottoChecker;
import domain.actor.impl.LottoPrizer;
import domain.actor.impl.LottoSeller;
import domain.lotto.Lotto;
import domain.lotto.number.LottoNumbers;
import domain.lotto.prize.Prizeable;
import domain.lotto.strategy.ManualNumberStrategy;
import domain.lotto.strategy.RandomNumberStrategy;
import domain.pay.Money;
import input.AdminReader;
import input.SellerReader;
import java.util.List;
import output.LottoResultWriter;
import output.LottoWriter;

public class LottoApplication {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public static void main(String[] args) {
        // init
        LottoBuildable builder = new LottoBuilder();
        LottoPrizeable prizer = new LottoPrizer();
        LottoMatchable checker = new LottoChecker(prizer);
        LottoSellable seller = new LottoSeller(new LottoBuilder(), LOTTO_PRICE);

        //input
        int money = SellerReader.getBuyMoney(LOTTO_PRICE);

        // logic
        List<Lotto> buyLottos = seller.buyLotto(new Money(money), new RandomNumberStrategy(LOTTO_NUMBER_SIZE));

        // output
        LottoWriter.writeLottos(buyLottos);

        // input
        List<Long> winningLottoNumber = AdminReader.getWinningLotto();
        Long bonusLottoNumber = AdminReader.getBounsLotto();

        // logic
        Lotto winningLotto = builder.build(new ManualNumberStrategy(new LottoNumbers(winningLottoNumber)));
        checker.settingWinningLotto(winningLotto);

        Lotto bonusLotto = builder.build(new ManualNumberStrategy(new LottoNumbers(bonusLottoNumber)));
        checker.settingBonusLotto(bonusLotto);

        List<Prizeable> prizeinfo = checker.getLottoPrizeInfo(buyLottos);

        //output
        LottoResultWriter.writePrizeInfo(money, prizer, prizeinfo);
    }
}
