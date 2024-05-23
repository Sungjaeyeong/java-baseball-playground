import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameMachineTest {

    @DisplayName("1부터 9까지의 랜덤한 수 생성")
    @Test
    void oneToNineRandomNumber() {
        GameMachine gameMachine = new GameMachine();
        int number = gameMachine.oneToNineRandomNumber();
        Assertions.assertThat(number).isBetween(1, 9);
    }
}