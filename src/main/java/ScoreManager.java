public class ScoreManager {
    private int strikes;
    private int balls;

    public void calculate(int[] answer, int enteredNumber) {
        String enteredNumberString = String.valueOf(enteredNumber);
        String[] userGuess = enteredNumberString.split("");

        for (int i = 0; i < 3; i++) {
            int guessedNumber = Integer.parseInt(userGuess[i]);
            checkStrikeOrBall(answer, guessedNumber, i);
        }
    }

    public boolean isPerfect() {
        return strikes == 3;
    }

    public void initScore() {
        this.strikes = 0;
        this.balls = 0;
    }

    public String generateResultMessage() {
        String result = "";
        if (balls > 0) result = balls + "볼";
        if (strikes > 0) result += strikes + "스트라이크";
        if (result.isEmpty()) result = "포볼";

        return result;
    }

    private void checkStrikeOrBall(int[] computerNumber, int guessedNumber, int index) {
        if (isStrike(computerNumber, guessedNumber, index)) {
            strikes++;
            return;
        }
        checkBall(computerNumber, guessedNumber);
    }

    private boolean isStrike(int[] computerNumber, int guessedNumber, int index) {
        return guessedNumber == computerNumber[index];
    }

    private void checkBall(int[] computerNumber, int guessedNumber) {
        if (contains(computerNumber, guessedNumber)) {
            balls++;
        }
    }

    public static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }
}
