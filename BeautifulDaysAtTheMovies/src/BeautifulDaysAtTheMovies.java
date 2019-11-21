/*
Lily likes to play games with integers. She has created a new game where she determines the
difference between a number and its reverse. For instance, given the number 12, its reverse is 21.
Their difference is 9. The number 120 reversed is 21, and their difference is 99.

She decides to apply her game to decision making. She will look at a numbered range of days and
will only go to a movie on a beautiful day.

Given a range of numbered days, [i..j] and a number k, determine the number of days in the range
that are beautiful. Beautiful numbers are defined as numbers where |i - reverse(i)| is evenly
divisible by k. If a day's value is a beautiful number, it is a beautiful day. Print the number of
beautiful days in the range.

Function Description

Complete the beautifulDays function in the editor below. It must return the number of beautiful days
in the range.

beautifulDays has the following parameter(s):

  i: the starting day number
  j: the ending day number
  k: the divisor

Input Format

A single line of three space-separated integers describing the respective values of i, j, and k.

Constraints

	1 <= i <= j <= 2 x 10^6
	1 <= k <= 2 x 10^9

Output Format

Print the number of beautiful days in the inclusive range between i and j.

Sample Input

20 23 6

Sample Output

2

Explanation

Lily may go to the movies on days 20, 21, 22, and 23. We perform the following calculations to
determine which days are beautiful:

    Day 20 is beautiful because the following evaluates to a whole number: (20 - 02) / 6 = 3
		Day 21 is not beautiful because the following doesn't evaluate to a whole number: (21 - 12) / 6 = 1.5
		Day 22 is beautiful because the following evaluates to a whole number: (22 - 22) / 6 = 0
		Day 23 is not beautiful because the following doesn't evaluate to a whole number: (23-32) / 6 = 1.5
		Only two days, 20 and 22, in this interval are beautiful. Thus, we print 22 as our answer.

Sample Input 2

13 45 3

Sample Output 2

33
*/

import java.util.Scanner;

public class BeautifulDaysAtTheMovies {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int start = scanner.nextInt();
		int end = scanner.nextInt();
		int divisor = scanner.nextInt();
		System.out.println(beautifulDays(start, end, divisor));
	}
	
	private static int beautifulDays(int i, int j, int k) {
		int numberOfBeautifulDays = 0;
		
			
		for (int iter = i; iter <= j; iter++) {
			if (Math.abs(iter - reverse(iter)) % k == 0){
				numberOfBeautifulDays++;
			}
		}
		return numberOfBeautifulDays;
	}
	
	private static int reverse(int number) {
		int reverse = 0;
		
		while (number != 0) {
			reverse = reverse * 10 + number % 10;
			number = number / 10;
		}
		return reverse;
	}
}