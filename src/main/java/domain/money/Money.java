package domain.money;

/**
 * @author delf
 */
public class Money {
	public final static Money ZERO = new Money(0);

	private int amount;

	public Money(int amount) {
		this.amount = getValueIfNotZero(amount);
	}

	public static Money of(int money) {
		return new Money(money);
	}

	public static Money of(Money money) {
		return new Money(money.amount);
	}

	public Money plus(Money money) {
		this.amount += money.amount;
		return this;
	}

	public Money minus(Money money) {
		this.amount = getValueIfNotZero(this.amount - money.amount);
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
