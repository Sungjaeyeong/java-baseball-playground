import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine();
        gameMachine.gameStart();

        InputView inputView = new InputView();
        int enteredNumber = inputView.enterNumber();

    }
}
