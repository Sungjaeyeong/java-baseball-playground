package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Balls {
    List<Ball> ballList;

    public Balls(int no1, int no2, int no3) {
        if (no1 == no2 || no1 == no3 || no2 == no3) throw new IllegalArgumentException("각 번호는 서로 같을 수 없습니다.");

        this.ballList = Arrays.asList(
                new Ball(no1, BallOrder.FIRST),
                new Ball(no2, BallOrder.SECOND),
                new Ball(no3, BallOrder.THIRD)
        );

    }

    public boolean isStrike(Ball ball) {
        Optional<Ball> sameOrderBall = ballList.stream()
                .filter(it -> it.ballOrder.equals(ball.ballOrder) && it.no == ball.no)
                .findFirst();
        return sameOrderBall.isPresent();
    }

    public boolean isBall(Ball ball) {
        return !isStrike(ball) && ballList.contains(ball);
    }
}
