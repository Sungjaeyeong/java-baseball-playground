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

        Ball firstBall = answer.get(0);
        Ball secondBall = answer.get(1);
        Ball thirdBall = answer.get(2);

        assertThat(firstBall).isNotEqualTo(secondBall);
        assertThat(firstBall).isNotEqualTo(thirdBall);
        assertThat(secondBall).isNotEqualTo(thirdBall);
    }

}