import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameMachine {
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
        generateUniqueThreeDigitArray();
        InputView inputView = new InputView();
        int enteredNumber = inputView.enterNumber();
    }
}
