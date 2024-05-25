import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameMachine {
    final InputView inputView;
    final ResultView resultView;
    private int strikes;
    private int balls;

    public GameMachine(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    int oneToNineRandomNumber() {
        Random random = new Random();
        return 1 + random.nextInt(9);
    }

    int[] generateUniqueThreeDigitArray() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 3) {
            uniqueNumbers.add(oneToNineRandomNumber());
        }

        int[] result = new int[3];
        int i = 0;
        for (int number : uniqueNumbers) {
            result[i++] = number;
        }

        return result;
    }

    public void gameStart() {
        int[] computerNumber = generateUniqueThreeDigitArray();
        System.out.println("computerNumber = " + Arrays.toString(computerNumber));

        playTurn(computerNumber);
        resultView.printEnd();

        selectContinue(inputView);
    }

    private void selectContinue(InputView inputView) {
        if (inputView.continueNumber() == 1) {
            strikes = 0;
            balls = 0;
            gameStart();
        }
    }

    private void playTurn(int[] computerNumber) {
        while (strikes < 3) {
            strikes = 0;
            balls = 0;

            int enteredNumber = inputView.enterNumber();
            String enteredNumberString = String.valueOf(enteredNumber);
            String[] userGuess = enteredNumberString.split("");

            calculateScore(computerNumber, userGuess);

            generateResultMessage();
        }
    }

    private void calculateScore(int[] computerNumber, String[] userGuess) {
        for (int i = 0; i < 3; i++) {
            int guessedNumber = Integer.parseInt(userGuess[i]);
            checkStrikeOrBall(computerNumber, guessedNumber, i);
        }
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

    private void generateResultMessage() {
        String result = "";
        if (balls > 0) result = balls + "볼";
        if (strikes > 0) result += strikes + "스트라이크";
        if (result.isEmpty()) result = "포볼";

        resultView.printResult(result);
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
