import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameMachine {
    private int strikes;
    private int balls;

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

        while (strikes < 3) {
            strikes = 0;
            balls = 0;

            InputView inputView = new InputView();
            int enteredNumber = inputView.enterNumber();
            String enteredNumberString = String.valueOf(enteredNumber);
            String[] userGuess = enteredNumberString.split("");

            for (int i = 0; i < 3; i++) {
                if (Integer.parseInt(userGuess[i]) == computerNumber[i]) {
                    strikes++;
                } else if (contains(computerNumber, Integer.parseInt(userGuess[i]))) {
                    balls++;
                }
            }

            String result = "";
            if (balls > 0) result = balls + "볼";
            if (strikes > 0) result += strikes + "스트라이크";
            if (result.isEmpty()) result = "포볼";

            System.out.println(result);
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
