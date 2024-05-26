import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GeneratorTest {
    @DisplayName("정답 생성")
    @Test
    void generateAnswer() {
        int[] answer = Generator.generateAnswer();
        assertThat(answer.length).describedAs("길이는 3이어야 한다.").isEqualTo(3);

        // 배열의 값들이 서로 다른지 확인
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : answer) {
            uniqueNumbers.add(number);
        }

        assertThat(uniqueNumbers.size()).describedAs("각 요소는 서로 다른 값이어야 한다.").isEqualTo(3);

        for (int number : answer) {
            assertThat(number)
                    .describedAs("각 요소는 1부터 9사이에 속해야 한다.")
                    .isBetween(1, 9);
        }
    }
}