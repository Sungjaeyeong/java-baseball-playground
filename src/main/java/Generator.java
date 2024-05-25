import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Generator {
    public static int[] generateAnswer() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 3) {
            uniqueNumbers.add(oneToNineRandomNumber());
        }

        int[] result = new int[3];
        int i = 0;
        for (int number : uniqueNumbers) {
            result[i++] = number;
        }
        System.out.println("answer = " + Arrays.toString(result));

        return result;
    }

    private static int oneToNineRandomNumber() {
        Random random = new Random();
        return 1 + random.nextInt(9);
    }
}
