package domain.money;

/**
 * @author delf
 */
public class Money {
	private int amount;
	public final static Money ZERO = new Money(0);

	public Money(int amount) {
		this.amount = getValueIfNotZero(amount);
	}

	public Money plus(Money money) {
		this.amount += money.amount;
		return this;
	}

	public Money minors(Money money) {
		this.amount = getValueIfNotZero(this.amount - money.amount);
		return this;
	}

	public Money divide(Money money) {
		if (money.equals(Money.ZERO)) {
			throw new IllegalArgumentException();
		}
		this.amount /= money.amount;

		return this;
	}

	public Money remainder(Money money) {
		this.amount %= money.amount;
		return this;
	}

	private int getValueIfNotZero(int value) {
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		return value;
	}

	public int getAmount() {
		return this.amount;
	}
}
