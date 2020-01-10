import domain.actor.LottoBuildable;
import domain.actor.LottoMatchable;
import domain.actor.LottoPrizeable;
import domain.actor.LottoSellable;
import domain.actor.impl.LottoBuilder;
import domain.actor.impl.LottoChecker;
import domain.actor.impl.LottoPrizer;
import domain.actor.impl.LottoSeller;
import domain.lotto.Lotto;
import domain.lotto.number.NumberLottoValue;
import domain.lotto.prize.LottoPrize;
import domain.lotto.prize.Prizeable;
import domain.lotto.strategy.ManualStrategy;
import domain.lotto.strategy.RandomStrategy;
import domain.wallet.Wallet;
import input.AdminReader;
import input.SellerReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import output.LottoResultWriter;
import output.LottoWriter;

public class LottoApplication {

    public static void main(String[] args) {

        //input
        int money = SellerReader.getBuyMoney();

        // logic
        LottoBuildable builder = new LottoBuilder();
        LottoSellable seller = new LottoSeller(builder, 1000);
        List<Lotto> lottos = seller.buyLotto(new Wallet(money), new RandomStrategy());

        // output
        LottoWriter.writeLottos(lottos);

        // input
        List<Long> winningLottoNumber = AdminReader.getWinningLotto();

        // logic
        Lotto winningLotto = builder.build(1, new ManualStrategy(winningLottoNumber.stream().map(NumberLottoValue::new).collect(Collectors.toList()))).get(0);
        LottoPrizeable prizer = new LottoPrizer();
        List<Prizeable> prizeables = new ArrayList<>();
        prizeables.add(new LottoPrize(3, 5000));
        prizeables.add(new LottoPrize(4, 50000));
        prizeables.add(new LottoPrize(5, 1500000));
        prizeables.add(new LottoPrize(6, 2000000000));
        prizer.setPrizeInfo(prizeables);

        LottoMatchable checker = new LottoChecker(prizer);
        checker.settingWinningLotto(winningLotto);
        List<Prizeable> prizeinfo = checker.getLottoPrizeInfo(lottos);

        //output
        LottoResultWriter.writePrizeInfo(money, prizer, prizeinfo);
    }
}
