package baseball;

import java.util.List;

public class Referee {
    public Score score(Balls answer, Balls enteredNumber) {
        Score score = new Score();
        List<Ball> ballList = enteredNumber.getBallList();
        for (Ball ball : ballList) {
            if (answer.isStrike(ball)) score.plusStrike();
            if (answer.isBall(ball)) score.plusBall();
        }
        return score;
    }
}
