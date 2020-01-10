package output;

import domain.lotto.Lotto;
import java.util.List;

public class LottoWriter {

    private static final String FORMAT = "[%s]";

    public static void writeLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(String.format(FORMAT, lotto.toString()));
        }
    }
}
