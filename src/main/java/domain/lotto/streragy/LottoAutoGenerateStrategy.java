package domain.lotto.streragy;

import domain.lotto.Lotto;
import domain.lotto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author delf
 */
public class LottoAutoGenerateStrategy implements LottoGenerateStrategy {

	private static List<Integer> lottoNumberList = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX).boxed().collect(Collectors.toList());

	@Override
	public Lotto generateLotto() {
		Collections.shuffle(lottoNumberList);
		return new Lotto(lottoNumberList.stream().limit(Lotto.PICK_NUM).map(LottoNumber::of).collect(Collectors.toList()));
	}
}
