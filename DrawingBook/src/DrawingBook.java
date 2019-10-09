/*
Brie’s Drawing teacher asks her class to open their books to a page number. Brie can either start
 turning pages from the front of the book or from the back of the book. She always turns pages
 one at a time. When she opens the book, page 1 is always on the right side:
   _______
	|   |   |
	| 0 | 1 |
	|___|___|



When she flips page 1, she sees pages 2 and 3. Each page except the last page will always be printed
on both sides. The last page may only be printed on the front, given the length of the book. If
the book is n pages long, and she wants to turn to page p, what is the minimum number of pages she
 will turn? She can start at the beginning or the end of the book.

Given n and p, find and print the minimum number of pages Brie must turn in order to arrive at
page p.

Function Description

Complete the pageCount function in the editor below. It should return the minimum number of pages
 Brie must turn.

pageCount has the following parameter(s):

    n: the number of pages in the book
    p: the page number to turn to

Input Format

The first line contains an integer n, the number of pages in the book.
The second line contains an integer, p, the page that Brie's teacher wants her to turn to.

Constraints
	1 <= n <= 10^5
	1 <= p <= n

Output Format

Print an integer denoting the minimum number of pages Brie must turn to get to page p.

Sample Input 0
6
2

Sample Output 0
1

Sample Input:
6
5

Sample output:
1
 */

import java.util.Scanner;

public class DrawingBook {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numberOfPages = scanner.nextInt();
		int pageWeAreLookingFor = scanner.nextInt();
		
		System.out.println(pageCount(numberOfPages, pageWeAreLookingFor));
	}
	
	public static int pageCount(int n, int p) {

		// someone else's elegant solution
		/*n = n / 2;
		p = p / 2;

		return p < (n - p) ? p : (n - p);*/

		// my solution
		if (p > n / 2) {
			if (n % 2 == 0 && n - p == 1){
				return 1;
			}
			return pageCount(n, n - p);
		} else {
			return (p / 2);
		}
	}
}