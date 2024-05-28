package baseball;

public class Ball {
    int no;

    public Ball(int no) {
        validate(no);
        this.no = no;
    }

    private static void validate(int no) {
        if (isValidNo(no)) throw new IllegalArgumentException("공의 숫자는 1부터 9사이여야 합니다.");
    }

    private static boolean isValidNo(int no) {
        return no < 1 || no > 9;
    }
}
