package domain.lotto.streragy;

import domain.lotto.Lotto;
import domain.lotto.LottoNumber;
import input.ConsoleInput;
import input.Inputtable;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;

/**
 * @author delf
 */
public class LottoManualGenerateStrategy implements LottoGenerateStrategy{

	private Inputtable inputInterface;

	public LottoManualGenerateStrategy(Inputtable inputInterface) {
		this.inputInterface = inputInterface;
	}

	@Override
	public Lotto generateLotto() {
		String inputValue = inputInterface.getStringValue();
		// 중복체크
		return new Lotto(Arrays.stream(inputValue.trim().split(","))
						.map(Integer::parseInt)
						.map(LottoNumber::of)
						.collect(toList()));
	}
}
