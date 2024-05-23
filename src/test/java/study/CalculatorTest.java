package study;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class CalculatorTest {

    @Test
    void test() {
        Scanner scanner = new Scanner(System.in);

        // String 입력 받기
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        System.out.println("You entered: " + inputString);
    }
}
