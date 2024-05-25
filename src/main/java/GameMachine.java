import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameMachine {
    final InputView inputView;
    final ResultView resultView;
    ScoreManager scoreManager;

    public GameMachine(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void gameStart() {
        int[] computerNumber = generateUniqueThreeDigitArray();
        System.out.println("computerNumber = " + Arrays.toString(computerNumber));

        playTurn(computerNumber);
        resultView.printEnd();

        selectContinue(inputView);
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

    private void selectContinue(InputView inputView) {
        if (inputView.continueNumber() == 1) {
            scoreManager.initScore();
            gameStart();
        }
    }

    private void playTurn(int[] computerNumber) {
        scoreManager = new ScoreManager(computerNumber);
        while (!scoreManager.isPerfect()) {
            scoreManager.initScore();

            int enteredNumber = inputView.enterNumber();
            scoreManager.calculate(enteredNumber);

            String resultMessage = scoreManager.generateResultMessage();
            resultView.printResult(resultMessage);
        }
    }
}
