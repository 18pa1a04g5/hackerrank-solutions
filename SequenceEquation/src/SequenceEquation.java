/*
Given a sequence of n integers, p(1), p(2),...,p(n) where each element is distinct and satisfies
1 <= p(x) <= n. For each x where 1 <= x <= n, find any integer y such that p(p(y)) ≡ x and print the
value of y on a new line.

For example, assume the sequence p = [5, 2, 1, 3, 4]. Each value of x between 1 and 5, the length of
the sequence, is analysed as follows:

	1. x = 1 ≡ p[3], p[4] = 3, so p[p[4]] = 1
	2. x = 2 ≡ p[2], p[2] = 2, so p[p[2]] = 2
	1. x = 3 ≡ p[4], p[5] = 4, so p[p[5]] = 3
	1. x = 4 ≡ p[5], p[1] = 5, so p[p[1]] = 4
	1. x = 5 ≡ p[1], p[3] = 1, so p[p[3]] = 5

The values for y are [4, 2, 5, 1, 3].

Function Description

Complete the permutationEquation function in the editor below. It should return an array of integers
that represent the values of y.

permutationEquation has the following parameter(s):

    p: an array of integers

Input Format

The first line contains an integer n, the number of elements in the sequence.
The second line contains n space-separated integers p[i] where 1 <= i <= n.

Constraints

	1 <= n <= 50
	1 <= p[i] <= 50, where 1 <= i <= n.
  Each element in the sequence is distinct.

Output Format

For each x from 1 to n, print an integer denoting any valid y satisfying the equation p(p(y)) ≡ x
on a new line.

Sample Input 0

3
2 3 1

Sample Output 0

2
3
1
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequenceEquation {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int numberOfElements = scanner.nextInt();
    int[] sequence = new int[numberOfElements];

    for (int i = 0; i < numberOfElements; i++) {
      sequence[i] = scanner.nextInt();
    }

    int[] result = permutationEquation(sequence);
    for (int number : result) {
      System.out.println(number);
    }
  }

  private static int[] permutationEquation(int[] p) {
    List<Integer> validValues = new ArrayList<>();
    int[] result;
    int[] positions = new int[p.length + 1];

    for (int i = 0; i < p.length; i++) {
      positions[p[i]] = i + 1;
    }

    for (int i = 1; i < positions.length; i++) {
      if (positions[i] == p[positions[positions[i]] - 1]) {
        validValues.add(positions[positions[i]]);
      }
    }

    result = new int[validValues.size()];

    for (int i = 0; i < validValues.size(); i++) {
      result[i] = validValues.get(i);
    }
    return result;
  }
}