import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ScoreManagerTest {
    @DisplayName("strikes 와 balls 필드가 점수에 맞게 변경되어야 한다")
    @Test
    void calculate() {
        ScoreManager scoreManager = new ScoreManager();
        int[] answer = {1, 2, 3};
        int enteredNumber = 123;

        scoreManager.calculate(answer, enteredNumber);
        assertThat(scoreManager.getStrikes()).isEqualTo(3);
        assertThat(scoreManager.getBalls()).isEqualTo(0);
    }


    @Nested
    class contains {
        @DisplayName("특정 값을 포함하고 있는 경우 true 를 반환")
        @Test
        void containsTrue() {
            int[] numbers = {1, 2, 3};
            int includeNumber = 1;

            assertTrue(ScoreManager.contains(numbers, includeNumber));
        }

        @DisplayName("특정 값을 포함하지 않는 경우 false 를 반환")
        @Test
        void containsFalse() {
            int[] numbers = {1, 2, 3};
            int excludeNumber = 4;

            assertFalse(ScoreManager.contains(numbers, excludeNumber));
        }
    }
}