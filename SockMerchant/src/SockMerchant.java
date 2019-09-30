/**
 * John works at a clothing store. He has a large pile of socks that he must pair by color for
 * sale. Given an array of integers representing the color of each sock, determine how many pairs
 * of socks with matching colors there are.
 *
 * For example, there are n = 7 socks with colors ar = [1, 2, 1, 2, 1, 3, 2]. There is one pair of 
 * color 1 and one of color 2. There are three odd socks left, one of each color. The number of 
 * pairs is 2.
 *
 * Function Description
 *
 * Complete the sockMerchant function in the editor below. It must return an integer representing
 * the number of matching pairs of socks that are available.
 *
 * sockMerchant has the following parameter(s):
 *
 *     n: the number of socks in the pile
 *     ar: the colors of each sock
 *
 * Input Format
 *
 * The first line contains an integer n, the number of socks represented in ar.
 * The second line contains n space-separated integers describing the colors ar[i] of the socks
 * in the pile.
 *
 * Constraints
 *
 * 	1 <= n <= 100
 * 	1 <= ar[i] <= 100, where 0 <= i < n
 *
 * Output Format
 *
 * Return the total number of matching pairs of socks that John can sell.
 *
 * Sample Input
 *
 * 9
 * 10 20 20 10 10 30 50 10 20
 *
 * Sample Output
 *
 * 3
 */
 
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] ar = new int[n];
		
		for (int i = 0; i < n; i++) {
			ar[i] = scanner.nextInt();
		}
		
		System.out.println(sockMerchant(n, ar));
	}
	
	public static int sockMerchant(int n, int[] ar) {
		Map<Integer, Integer> colorFrequencies = new HashMap<>();

		for (int number : ar) {
			if (colorFrequencies.containsKey(number)) {
				colorFrequencies.put(number, colorFrequencies.get(number) + 1);
			} else {
				colorFrequencies.put(number, 1);
			}
		}
		
		int numberOfPairs = 0;
		
		for (Map.Entry<Integer, Integer> colorFrequencyEntry : colorFrequencies.entrySet()) {
			int currentColorFrequency = colorFrequencyEntry.getValue();
			
			if (currentColorFrequency % 2 == 0) {
				numberOfPairs += currentColorFrequency / 2;
			} else {
				numberOfPairs += (currentColorFrequency - 1) / 2;
			}
		}
		
		return numberOfPairs;
	}
}