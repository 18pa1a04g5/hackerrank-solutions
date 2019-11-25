/*
An integer d is a divisor of an integer n if the remainder of n % d = 0.

Given an integer, for each digit that makes up the integer determine whether it is a divisor. Count
the number of divisors occurring within the integer.

Note: Each digit is considered to be unique, so each occurrence of the same digit should be counted
(e.g. for n = 111, 1 is a divisor of 111 each time it occurs so the answer is 3).

Function Description

Complete the findDigits function in the editor below. It should return an integer representing the
number of digits of d that are divisors of d.

findDigits has the following parameter(s):

  n: an integer to analyse

Input Format

The first line is an integer, t, indicating the number of test cases.
The t subsequent lines each contain an integer, n.

Constraints

  1 <= t <= 15
	0 < n < 10^9

Output Format

For every test case, count the number of digits in n that are divisors of n. Print each answer on a
new line.

Sample Input

2
12
1012

Sample Output

2
3

Explanation

The number 12 is broken into two digits, 1 and 2. When 12 is divided by either of those two digits,
the remainder is 0, so they are both divisors.

The number 1012 is broken into four digits, 1, 0, 1, and 2. 1012 is evenly divisible by its digits
1, 1, and 2, but it is not divisible by 0 as division by zero is undefined.
*/

import java.util.Scanner;

public class FindDigits {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		
		for (int i = 0; i < testCases; i++) {
			System.out.println(findDigits(scanner.nextInt()));
		}
	}
	
	private static int findDigits(int n) {
		int temp = n;
		int currentDivisor;
		int numberOfDivisors = 0;

		while (temp != 0) {
				currentDivisor = temp % 10;
				if (currentDivisor != 0 && n % currentDivisor == 0) {
						numberOfDivisors++;
				}
				temp = temp / 10;
		}

		return numberOfDivisors;
	}
}