/*
Given an array of integers, find and print the maximum number of integers you can select from the
array such that the absolute difference between any two of the chosen integers is less than or
equal to 1. For example, if your array is a = [1, 1, 2, 2, 4, 4, 5, 5, 5], you can create two
subarrays meeting the criterion: [1, 1, 2, 2] and [4, 4, 5, 5, 5]. The maximum length subarray
has 5 elements.

Function Description

Complete the pickingNumbers function. It should return an integer that
represents the length of the longest array that can be created.

pickingNumbers has the following parameter(s):

  a: an array of integers

Input Format

The first line contains a single integer n, the size of the array a.
The second line contains n space-separated integers a[i].

Constraints

  2 <= n <= 100
  0 < a[i] < 100
  The answer will be >= 2.

Output Format

A single integer denoting the maximum number of integers you can choose from the array such that
the absolute difference between any two of the chosen integers is <= 1.

Sample Input 0

6
4 6 5 3 3 1

Sample Output 0

3

Sample Input 1

6
1 2 2 3 1 2

Sample Output 1

5
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PickingNumbers {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int numberOfElements = scanner.nextInt();
    List<Integer> numbers = new ArrayList<>();

    for (int i = 0; i < numberOfElements; i++) {
      numbers.add(scanner.nextInt());
    }

    System.out.println(numbers);
    System.out.println(pickingNumbers(numbers));
  }

  private static int pickingNumbers(List<Integer> a) {
    Map<Integer, Integer> frequencyOfNumbers = new HashMap<>();

    for (int number : a) {
      if (frequencyOfNumbers.containsKey(number)) {
        frequencyOfNumbers.put(number, frequencyOfNumbers.get(number) + 1);
      } else {
        frequencyOfNumbers.put(number, 1);
      }
    }

    int maxArrayLength = 0;

    for (Integer key : frequencyOfNumbers.keySet()) {
      if (frequencyOfNumbers.containsKey(key + 1)) {
        maxArrayLength =
            (maxArrayLength < frequencyOfNumbers.get(key) + frequencyOfNumbers.get(key + 1)) ?
                frequencyOfNumbers.get(key) + frequencyOfNumbers.get(key + 1) : maxArrayLength;
      } else {
        maxArrayLength = (maxArrayLength < frequencyOfNumbers.get(key)) ?
            frequencyOfNumbers.get(key) : maxArrayLength;
      }
    }
    return maxArrayLength;
  }
}
