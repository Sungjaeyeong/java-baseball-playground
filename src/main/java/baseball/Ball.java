package baseball;

import java.util.Objects;

public class Ball {
    int no;
    BallOrder ballOrder;

    public Ball(int no, BallOrder ballOrder) {
        validate(no);
        this.no = no;
        this.ballOrder = ballOrder;
    }

    private static void validate(int no) {
        if (isValidNo(no)) throw new IllegalArgumentException("공의 숫자는 1부터 9사이여야 합니다.");
    }

    private static boolean isValidNo(int no) {
        return no < 1 || no > 9;
    }

    public int getNo() {
        return this.no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return no == ball.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}
