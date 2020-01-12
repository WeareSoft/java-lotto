package domain.lotto;

import java.util.Iterator;
import java.util.List;

/**
 * @author delf
 */
public class LottoCollection implements Iterable<Lotto> {
	private List<Lotto> lottoList;
	private int size;

	public LottoCollection(List<Lotto> lottoList) {
		this.lottoList = lottoList;
		this.size = lottoList.size();
	}

	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Lotto lotto : lottoList) {
			stringBuilder.append(lotto).append("\n");
		}
		return stringBuilder.toString();
	}


	@Override
	public Iterator<Lotto> iterator() {
		return lottoList.iterator();
	}
}
