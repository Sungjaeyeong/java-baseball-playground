package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class BallsTest {
    @Test
    void createTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Balls(1, 1, 1))
                .withMessageMatching("각 번호는 서로 같을 수 없습니다.");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Balls(1, 1, 2))
                .withMessageMatching("각 번호는 서로 같을 수 없습니다.");
    }

    @Test
    void isStrikeTest() {
        Balls balls = new Balls(1, 2, 3);
        Ball ball = new Ball(1, BallOrder.FIRST);
        assertTrue(balls.isStrike(ball));
    }
}