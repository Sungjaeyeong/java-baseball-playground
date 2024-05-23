import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        // String 입력 받기
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        System.out.println("You entered: " + inputString);
    }
}
