/*
	2
4 3
-1 -3 4 2
4 2
0 -1 2 1
 */

import java.util.Scanner;

public class AngryProfessor {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();

		int numberOfStudents, requiredNumberOfStudents;
		
		for (int i = 1; i <= numberOfTestCases; i++) {
			numberOfStudents = scanner.nextInt();
			requiredNumberOfStudents = scanner.nextInt();
			int[] studentArrivalTimes = new int[numberOfStudents];
			for (int j = 0; j < numberOfStudents; j++) {
				studentArrivalTimes[j] = scanner.nextInt();
			}
			
			System.out.println("Test case: " + i);
			System.out.println(angryProfessor(requiredNumberOfStudents, studentArrivalTimes));
		}
	}
	
	private static String angryProfessor(int k, int[] a) {
		int numberOfStudentsArrivedOnTime = 0;
		
		for (int arrivalTime : a) {
			numberOfStudentsArrivedOnTime += (arrivalTime <= 0) ? 1 : 0;
		}
		return (numberOfStudentsArrivedOnTime < k) ? "YES" : "NO";
	}
}