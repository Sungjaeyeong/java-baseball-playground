public class GameMachine {
    final InputView inputView;
    final ResultView resultView;
    ScoreManager scoreManager;

    public GameMachine(InputView inputView, ResultView resultView, ScoreManager scoreManager) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.scoreManager = scoreManager;
    }

    public void gameStart(int[] answer) {
        playTurn(answer);
        resultView.printEnd();
    }

    private void playTurn(int[] answer) {
        while (!scoreManager.isPerfect()) {
            scoreManager.initScore();
            scoreManager.calculate(answer, inputView.enterNumber());
            resultView.printResult(scoreManager.generateResultMessage());
        }
    }

    public void restart(int[] answer) {
        scoreManager.initScore();
        gameStart(answer);
    }

    public boolean isContinue() {
        return inputView.continueNumber() == 1;
    }
}
