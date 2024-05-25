import java.util.Arrays;

public class GameMachine {
    final InputView inputView;
    final ResultView resultView;
    ScoreManager scoreManager;

    public GameMachine(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void gameStart() {
        int[] computerNumber = Generator.generateUniqueThreeDigitArray();
        System.out.println("computerNumber = " + Arrays.toString(computerNumber));

        playTurn(computerNumber);
        resultView.printEnd();

        selectContinue(inputView);
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
