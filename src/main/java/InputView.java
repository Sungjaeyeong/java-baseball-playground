import java.util.Scanner;

public class InputView {
    int enterNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = scanner.nextLine();

        return Integer.parseInt(inputString);
    }
}
