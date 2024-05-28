package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    @Test
    void createTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(0))
                .withMessageMatching("공의 숫자는 1부터 9사이여야 합니다.");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(10))
                .withMessageMatching("공의 숫자는 1부터 9사이여야 합니다.");
    }

    @Test
    void equalsTest() {
        Ball ball1 = new Ball(1);
        Ball ball2 = new Ball(1);

        assertThat(ball1).isEqualTo(ball2);
    }
}