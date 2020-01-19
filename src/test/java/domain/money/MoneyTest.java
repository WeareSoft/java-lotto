package domain.money;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

	@Test
	void createMoneyWithNegativeNumber() {
		assertThrows(IllegalArgumentException.class, () -> new Money(-1));
	}

	@Test
	void addMoneyTest() {
		Money m1 = new Money(2000);
		Money m2 = new Money(1000);
		assertThat(m1.plus(m2).getAmount()).isEqualTo(3000);
	}

	@Test
	void minorsMoneyTest() {
		Money m1 = new Money(2000);
		Money m2 = new Money(1000);
		assertThat(m1.minus(m2).getAmount()).isEqualTo(1000);
	}

	@Test
	void minorsMoneyTestWhenNegativeResult() {
		Money m1 = new Money(1000);
		Money m2 = new Money(2000);
		assertThrows(IllegalArgumentException.class, () -> m1.minus(m2));
	}
}
