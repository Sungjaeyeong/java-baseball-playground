import java.util.Random;

public class GameMachine {
     int oneToNineRandomNumber() {
        Random random = new Random();
        return 1 + random.nextInt(9);
    }
}
