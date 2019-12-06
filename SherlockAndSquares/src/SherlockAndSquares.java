import java.util.Scanner;

public class SherlockAndSquares {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int testCases = scanner.nextInt();

    for (int i = 0; i < testCases; i++) {
      System.out.println(squares(scanner.nextInt(), scanner.nextInt()));
    }
  }

  private static int squares(int a, int b) {
    int numberOfSquareIntegers = 0;
    double squareRoot = Math.sqrt(a);
    int iterator;

    iterator = (int) (Math.ceil(squareRoot));

    while (iterator * iterator < b+1) {
      numberOfSquareIntegers++;
      iterator++;
    }

    return numberOfSquareIntegers;
  }
}
