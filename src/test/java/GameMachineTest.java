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

        // uniqueNumbers의 크기가 3인지 확인
        assertThat(uniqueNumbers.size()).isEqualTo(3);
    }
}