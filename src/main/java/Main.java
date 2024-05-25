import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine(new InputView(), new ResultView());
        gameMachine.gameStart();
    }
}
