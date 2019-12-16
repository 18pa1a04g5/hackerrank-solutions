/*
You have a string of lowercase English alphabetic letters. You can perform two types of operations
on the string:

  1. Append a lowercase English alphabetic letter to the end of the string.
  2. Delete the last character in the string. Performing this operation on an empty string results
  in an empty string.

Given an integer, k, and two strings, s and t, determine whether or not you can convert s to t by
performing exactly k of the above operations on s. If it's possible, print Yes. Otherwise, print No.

For example, strings s = [a, b, c] and t = [d, e, f]. Our number of moves, k = 6. To convert s to t,
we first delete all of the characters in 3 moves. Next we add each of the characters of t in order.
On the 6th move, you will have the matching string. If there had been more moves available, they
could have been eliminated by performing multiple deletions on an empty string. If there were fewer
than 6 moves, we would not have succeeded in creating the new string.

Function Description

Complete the appendAndDelete function in the editor below. It should return a string, either Yes or
No.
appendAndDelete has the following parameter(s):

  s: the initial string
  t: the desired string
  k: an integer that represents the number of operations

Input Format

The first line contains a string s, the initial string.
The second line contains a string t, the desired final string.
The third line contains an integer k, the number of operations.

Constraints

  1 <= |s| <= 100
  1 <= |t| <= 100
  1 <= k <= 100

  s and t consist of lowercase English alphabetic letters, ASCII [a-z].

Output Format

Print Yes if you can obtain string t by performing exactly k operations on s. Otherwise, print No.

Sample Input 0

hackerhappy
hackerrank
9

Sample Output 0

Yes

Sample Input 1

aba
aba
7

Sample Output 1

Yes

Sample Input 2

ashley
ash
2

Sample Output 2

No

Sample Input 3

y
yu
2

Sample Output 3

No
*/

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class AppendAndDelete {

  public static void main(String[] args) {

    /*Scanner scanner = new Scanner(System.in);
    String stringToConvert = scanner.next();
    String desiredResult = scanner.next();
    int numberOfOperations = scanner.nextInt();
    System.out.println(appendAndDelete(stringToConvert, desiredResult, numberOfOperations));*/
    assertEquals("Yes", appendAndDelete("hackerhappy", "hackerrank", 9));
    assertEquals("Yes", appendAndDelete("aba", "aba", 7));
    assertEquals("No", appendAndDelete("ashley", "ash", 2));
    assertEquals("No", appendAndDelete("y", "yu", 2));
    assertEquals("Yes", appendAndDelete("zzzzz", "zzzzzzz", 4));
    assertNotEquals("No", appendAndDelete("y", "yu", 3));
  }

  private static String appendAndDelete(String s, String t, int k) {
    int sLength = s.length();
    int tLength = t.length();

    if (s.equals(t) && k > 1) {
      return "Yes";
    }

    int minLength = Math.min(sLength, tLength);
    int lengthUntilEqual = 0;

    for (int i = 0; i < minLength; i++) {
      if (s.charAt(i) == t.charAt(i)) {
        lengthUntilEqual++;
      } else {
        break;
      }
    }

    int numberOfCharsToDelete = sLength - lengthUntilEqual;
    int numberOfCharsToAppend = tLength - lengthUntilEqual;
    int numberOfOperations = numberOfCharsToDelete + numberOfCharsToAppend;

    if (sLength < tLength) {
      if ((k - numberOfOperations) % 2 == 0) {
        return "Yes";
      } else {
        return "No";
      }
    } else if (k >= numberOfOperations) {
      return "Yes";
    }

    return "No";
  }
}
