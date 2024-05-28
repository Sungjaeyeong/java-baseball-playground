package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    @Test
    void create() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(0))
                .withMessageMatching("공의 숫자는 1부터 9사이여야 합니다.");
    }
}