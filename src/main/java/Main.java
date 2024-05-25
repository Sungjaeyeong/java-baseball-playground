public class Main {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine(
                new InputView(),
                new ResultView(),
                new ScoreManager()
        );

        gameMachine.gameStart(Generator.generateAnswer());
        while (gameMachine.isContinue()) {
            gameMachine.restart(Generator.generateAnswer());
        }
    }
}
