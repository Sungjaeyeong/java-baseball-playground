import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameMachineTest {

    @DisplayName("1부터 9까지의 랜덤한 수 생성")
    @Test
    void oneToNineRandomNumber() {
        GameMachine gameMachine = new GameMachine();
        int number = gameMachine.oneToNineRandomNumber();
        assertThat(number).isBetween(1, 9);
    }

    @DisplayName("서로 다른 3자리 수 생성")
    @Test
    void generateUniqueThreeDigitArray() {
        GameMachine gameMachine = new GameMachine();
        int[] numbers = gameMachine.generateUniqueThreeDigitArray();
        assertThat(numbers.length).isEqualTo(3);

        // 배열의 값들이 서로 다른지 확인
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            uniqueNumbers.add(number);
        }

        assertThat(uniqueNumbers.size()).isEqualTo(3);
    }

    @DisplayName("contains 함수는 특정 값을 포함하고 있는 경우 true 를 반환")
    @Test
    void containsTrue() {
        int[] numbers = {1, 2, 3};
        int includeNumber = 1;

        assertTrue(GameMachine.contains(numbers, includeNumber));
    }

    @DisplayName("contains 함수는 특정 값을 포함하지 않는 경우 false 를 반환")
    @Test
    void containsFalse() {
        int[] numbers = {1, 2, 3};
        int excludeNumber = 4;

        assertFalse(GameMachine.contains(numbers, excludeNumber));
    }
}