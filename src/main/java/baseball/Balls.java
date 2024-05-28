package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
    Ball firstBall;
    Ball secondBall;
    Ball thirdBall;

    public Balls(int no1, int no2, int no3) {
        if (no1 == no2 || no1 == no3 || no2 == no3) throw new IllegalArgumentException("각 번호는 서로 같을 수 없습니다.");
        this.firstBall = new Ball(no1, BallOrder.FIRST);
        this.secondBall = new Ball(no2, BallOrder.FIRST);
        this.thirdBall = new Ball(no3, BallOrder.FIRST);
    }


    public boolean isStrike(Ball ball) {
        return true;
    }
}
