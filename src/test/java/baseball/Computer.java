package baseball;

import java.util.Arrays;
import java.util.List;

public class Computer {
    public List<Ball> createAnswer() {
        return Arrays.asList(new Ball(1, BallOrder.FIRST), new Ball(2, BallOrder.FIRST), new Ball(3, BallOrder.FIRST));
    }
}
