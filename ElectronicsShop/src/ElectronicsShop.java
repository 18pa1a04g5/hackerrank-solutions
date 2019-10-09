/*
Monica wants to buy a keyboard and a USB drive from her favorite electronics store. The store has
 several models of each. Monica wants to spend as much as possible for the 2 items, given her
 budget.

Given the price lists for the store's keyboards and USB drives, and Monica's budget, find and
print the amount of money Monica will spend. If she doesn't have enough money to both a keyboard
and a USB drive, print -1 instead. She will buy only the two required items.

For example, suppose she has b = 60 to spend. Three types of keyboards cost keyboard = [40, 50, 60].
 Two USB drives cost drive = [5, 8, 12]. She could purchase a "40 keyboard + 12 USB drive = 52",
 or a "50 keyboard + 8 USB drive = 58". She chooses the latter. She can't buy more than 2 items so
  she can't spend exactly 60.

Function Description

Complete the getMoneySpent function in the editor below. It should return the maximum total price
 for the two items within Monica's budget, or -1 if she cannot afford both items.

getMoneySpent has the following parameter(s):

    keyboards: an array of integers representing keyboard prices
    drives: an array of integers representing drive prices
    b: the units of currency in Monica's budget

Input Format

The first line contains three space-separated integers b, n and m, her budget, the number of
keyboard models and the number of USB drive models.
The second line contains n space-separated integers keyboard[i], the prices of each keyboard
model.
The third line contains m space-separated integers drives[i], the prices of the USB drives.

Constraints

    1 <= n,m <= 1000
    1 <= b <= 10^6.

		The price of each item is in the inclusive range [1, 10^6]

Output Format

Print a single integer denoting the amount of money Monica will spend. If she doesn't have enough
 money to buy one keyboard and one USB drive, print -1 instead.

Sample Input 0

10 2 3
3 1
5 2 8

Sample Output 0

9


Sample Input 1

5 1 1
4
5

Sample Output 1

-1
 */
 
import java.util.Arrays;
import java.util.Scanner;

public class ElectronicsShop {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int budget = scanner.nextInt();
		int numberOfKeyboards = scanner.nextInt();
		int numberOfUSBDrives = scanner.nextInt();
		
		int[] keyboardPrices = new int[numberOfKeyboards];
		int[] usbDrivePrices = new int[numberOfUSBDrives];
		
		for (int i = 0; i < numberOfKeyboards; i++) {
			keyboardPrices[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < numberOfUSBDrives; i++) {
			usbDrivePrices[i] = scanner.nextInt();
		}
		
		System.out.println(Arrays.toString(keyboardPrices));
		System.out.println(Arrays.toString(usbDrivePrices));	
		System.out.println(getMoneySpent(keyboardPrices, usbDrivePrices, budget));	
	}
	
	public static int getMoneySpent(int[] keyboards, int[] drives, int budget) {
		int moneySpent = -1;
		int total;
		
		for (int keyboard : keyboards) {
			for (int drive : drives) {
				total = keyboard + drive;
				if (total <= budget && total > moneySpent) {
					moneySpent = total;
				}
			}
		}
		return moneySpent;
	}
}