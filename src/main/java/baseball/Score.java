package baseball;

public class Score {
    private int strike;
    private int ball;

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) return "낫싱";
        String result = "";
        if (ball != 0) result += ball + "볼 ";
        if (strike != 0) result += strike + "스트라이크";
        return result;
    }

    public void plusStrike() {
        strike++;
    }

    public void plusBall() {
        ball++;
    }
}
