/*
Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details
like topography. During his last hike he took exactly n steps. For every step he took, he noted if
it was an uphill, U, or a downhill, D step. Gary's hikes start and end at sea level and each step
up or down represents a 1 unit change in altitude. We define the following terms:

A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea
level and ending with a step down to sea level.

A valley is a sequence of consecutive steps below sea level, starting with a step down from sea
level and ending with a step up to sea level.

Given Gary's sequence of up and down steps during his last hike, find and print the number of
valleys he walked through.

For example, if Gary's path is s = [D,D,U,U,U,U,D,D], he first enters a valley 2 units deep. Then
he climbs out an up onto a mountain 2 units high. Finally, he returns to sea level and ends his
hike.

Function Description

Complete the countingValleys function in the editor below. It must return an integer that denotes
the number of valleys Gary traversed.

countingValleys has the following parameter(s):

  n: the number of steps Gary takes
  s: a string describing his path

Input Format

The first line contains an integer n, the number of steps in Gary's hike.
The second line contains a single string s, of n characters that describe his path.

Constraints

	2 <= n <= 10^6
	s[i] in {U,D}

Output Format

Print a single integer that denotes the number of valleys Gary walked through during his hike.

Sample Input

8
UDDDUDUU

Sample Output

1

Explanation

If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:

_/\      _
   \    /
    \/\/

He enters and leaves one valley.

*/

import java.util.Scanner;

public class CountingValleys {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int numberOfSteps = scanner.nextInt();
    String steps = scanner.next();

    System.out.println(steps);
    System.out.println(countingValleys(numberOfSteps, steps));
  }

  private static int countingValleys(int n, String s) {

    int valleysWalkedThrough = 0;
    int level = 0;
    int previousLevel = 0;

    for (int i = 0; i < n; i++) {
      // my solution
			/*level = (s.charAt(i) == 'U') ? level+1 : level-1;
			valleysWalkedThrough = (previousLevel == -1 && level == 0) ? valleysWalkedThrough + 1 :
					valleysWalkedThrough;
			previousLevel = level;*/

      // someone else's solution
      // I should have paid attention to the challenge description, since it states that Gary's
      // hikes always end at sea level, so the number of valleys traversed depends only on the fact
      // that he makes step down from sea level (level == 0 before a downwards step)
      if (s.charAt(i) == 'U') {
        level++;
      } else if (s.charAt(i) == 'D') {
        if (level == 0) {
          valleysWalkedThrough++;
        }
        level--;
      }
    }

    return valleysWalkedThrough;
  }
}