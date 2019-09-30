/**
 * Anna and Brian are sharing a meal at a restuarant and they agree to split the bill equally.
 * Brian wants to order something that Anna is allergic to though, and they agree that Anna won't
 * pay for that item. Brian gets the check and calculates Anna's portion. You must determine if
 * his calculation is correct.
 *
 * For example, assume the bill has the following prices: bill = [2, 4, 6]. Anna declines to eat
 * item k = bill[2] which costs 6. If Brian calculates the bill correctly, Anna will pay
 * (2 + 4) / 2 = 6 . If he includes the cost of bill[2], he will calculate (2 + 4 + 6) / 2 = 6. In
 * the second case, he should refund 3 to Anna.
 *
 * Function Description
 *
 * Complete the bonAppetit function in the editor below. It should print Bon Appetit if the bill
 * is fairly split. Otherwise, it should print the integer amount of money that Brian owes Anna.
 *
 * bonAppetit has the following parameter(s):
 *
 *     bill: an array of integers representing the cost of each item ordered
 *     k: an integer representing the zero-based index of the item Anna doesn't eat
 *     b: the amount of money that Anna contributed to the bill
 *
 * Input Format
 *
 * The first line contains two space-separated integers n and k, the number of items ordered and the
 * 0-based index of the item that Anna did not eat.
 * The second line contains n space-separated integers bill[i] where 0 <= i < n.
 * The third line contains an integer, b, the amount of money that Brian charged Anna for her
 * share of the bill.
 *
 * Constraints
 *
 * 	2 <= n <= 10^5
 * 	0 <= k < n
 * 	0 <= bill[i] <= 10^4
 * 	0 <= b <= bill[0] + bill[1] + ... + bill[n-1]
 *  The amount of money due Anna will always be an integer
 *
 * Output Format
 *
 * If Brian did not overcharge Anna, print Bon Appetit on a new line; otherwise, print the
 * difference (i.e., b(charged) - b(actual)) that Brian must refund to Anna. This will always be an
 * integer.
 *
 * Sample Input 0
 *
 * 4 1
 * 3 10 2 9
 * 12
 *
 * Sample Output 0
 *
 * 5
 */
 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BonAppetit {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numberOfItems = scanner.nextInt();
		int indexOfUnchargedItem = scanner.nextInt();
		List<Integer> costOfItems = new ArrayList<>();
		
		for (int i = 0; i < numberOfItems; i++){
			costOfItems.add(scanner.nextInt());
		}
		
		int chargedAmount = scanner.nextInt();
		
		bonAppetit(costOfItems, indexOfUnchargedItem, chargedAmount);
	}
	
	public static void bonAppetit(List<Integer> bill, int k, int b){
		int annasShare = 0;
		int costOfItemsAnnaPaysFor = 0;
		for (int i = 0; i < bill.size(); i++){
			if (i != k) {
				costOfItemsAnnaPaysFor += bill.get(i);
			}
		}
		
		annasShare = costOfItemsAnnaPaysFor / 2;
		
		if (annasShare == b) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println((b - annasShare));
		}
	}
}