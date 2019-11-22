/*
John Watson knows of an operation called a right circular rotation on an array of integers. One
rotation operation moves the last array element to the first position and shifts all remaining
elements right one. To test Sherlock's abilities, Watson provides Sherlock with an array of
integers. Sherlock is to perform the rotation operation a number of times then determine the value
of the element at a given position.

For each array, perform a number of right circular rotations and return the value of the element at
a given index.

For example, array a = [3, 4, 5], number of rotations, k = 2 and indices to check, m = [1, 2].
First we perform the two rotations: [3,4,5] → [5,3,4] → [4,5,3]

Now return the values from the zero-based indices 1 and 2 as indicated in the m array.
a[1] = 5
a[2] = 3

Function Description

Complete the circularArrayRotation function in the editor below. It should return an array of
integers representing the values at the specified indices.

circularArrayRotation has the following parameter(s):

  a: an array of integers to rotate
  k: an integer, the rotation count
  queries: an array of integers, the indices to report

Input Format

The first line contains 3 space-separated integers, n, k, and q, the number of elements in the
integer array, the rotation count and the number of queries.
The second line contains n space-separated integers, where each integer i describes array element
 a[i] (where 0 <= i < n).
Each of the q subsequent lines contains a single integer denoting m, the index of the element to
return from a.

Constraints

  1 <= n <= 10^5
  1 <= a[i] <= 10^5
  1 <= k <= 10^5
  1 <= q <= 500
  0 <= m < n

Output Format

For each query, print the value of the element at index m of the rotated array on a new line.

Sample Input 0

3 2 3
1 2 3
0
1
2

Sample Output 0

2
3
1
 */

import java.util.Scanner;

public class CircularArrayRotation {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numbersInArray = scanner.nextInt();
    int rotations = scanner.nextInt();
    int numberOfQueries = scanner.nextInt();
    int[] array = new int[numbersInArray];
    int[] queries = new int[numberOfQueries];

    for (int i = 0; i < numbersInArray; i++) {
      array[i] = scanner.nextInt();
    }

    for (int i = 0; i < numberOfQueries; i++) {
      queries[i] = scanner.nextInt();
    }

    int[] rotatedArray = circularArrayRotation(array, rotations, queries);
    for (int query : queries) {
      System.out.println(rotatedArray[query]);
    }
  }

  private static int[] circularArrayRotation(int[] a, int k, int[] queries) {
    int[] rotatedArray = new int[a.length];

    for (int i = 0; i < a.length; i++) {
      if (i + k > a.length - 1) {
        rotatedArray[(i + k) % a.length] = a[i];
      } else {
        rotatedArray[i + k] = a[i];
      }
    }

    return rotatedArray;
  }
}
