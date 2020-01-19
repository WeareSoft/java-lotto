package domain.actor;

import domain.actor.impl.LottoPrizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizerTest {

    private LottoPrizeable prizer;

    @BeforeEach
    public void setUp() {
        prizer = new LottoPrizer();
    }

    @Test
    @DisplayName("LottoPrize정보를 등록후 가져올 수 있다")
    public void test() {
//        prizer.setPrizeStrategy();
    }

    @Test
    @DisplayName("LottoPrize정보가 없다면 빈값을 반환한다")
    public void test2() {

    }
}