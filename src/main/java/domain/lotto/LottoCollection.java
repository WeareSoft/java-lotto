package domain.lotto;

import java.util.Iterator;
import java.util.List;

/**
 * @author delf
 */
public class LottoCollection implements Iterable<Lotto> {
	private List<Lotto> lottoList;

	public LottoCollection(List<Lotto> lottoList) {
		if(lottoList.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.lottoList = lottoList;
	}

	@Override
	public Iterator<Lotto> iterator() {
		return lottoList.iterator();
	}

	public int size() {
		return lottoList.size();
	}
}
