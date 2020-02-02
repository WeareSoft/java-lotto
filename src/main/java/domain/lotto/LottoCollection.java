package domain.lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author delf
 */
public class LottoCollection implements Iterable<Lotto> {
	private List<Lotto> lottoList;

	public LottoCollection() {
		lottoList = new ArrayList<>();
	}

	public LottoCollection(List<Lotto> lottoList) {
		if(lottoList.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.lottoList = lottoList;
	}

	public void addAll(LottoCollection lottoCollection) {
		lottoList.addAll(lottoCollection.getLottoList());
	}

	@Override
	public Iterator<Lotto> iterator() {
		return lottoList.iterator();
	}

	public int size() {
		return lottoList.size();
	}

	private List<Lotto> getLottoList() {
		return lottoList;
	}
}
