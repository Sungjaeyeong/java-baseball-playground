package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    @Test
    void createAnswer() {
        Computer computer = new Computer();
        List<Ball> answer = computer.createAnswer();
        assertThat(answer.size()).isEqualTo(3);

        int firstBallNo = answer.get(0).getNo();
        int secondBallNo = answer.get(1).getNo();
        int thirdBallNo = answer.get(2).getNo();

        assertThat(firstBallNo).isNotEqualTo(secondBallNo);
        assertThat(firstBallNo).isNotEqualTo(thirdBallNo);
        assertThat(secondBallNo).isNotEqualTo(thirdBallNo);
    }

}