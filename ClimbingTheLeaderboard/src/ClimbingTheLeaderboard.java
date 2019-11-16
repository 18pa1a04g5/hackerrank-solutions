/*
Alice is playing an arcade game and wants to climb to the top of the leaderboard and wants to track 
her ranking. The game uses Dense Ranking, so its leaderboard works like this:

    The player with the highest score is ranked number 1 on the leaderboard.
    Players who have equal scores receive the same ranking number, and the next player(s) receive 
		the immediately following ranking number.

For example, the four players on the leaderboard have high scores of 100, 90, 90 and 80. Those 
players will have ranks 1, 2, 2 and 3, respectively. If Alice's scores are 70, 80 and 105, her 
rankings after each game are 4, 3 and 1.

Function Description

Complete the climbingLeaderboard function in the editor below. It should return an integer array 
where each element res[j] represents Alice's rank after the j-th game.

climbingLeaderboard has the following parameter(s):

    scores: an array of integers that represent leaderboard scores
    alice: an array of integers that represent Alice's scores

Input Format

The first line contains an integer n, the number of players on the leaderboard.
The next line contains n space-separated integers scores[i], the leaderboard scores in decreasing 
order.
The next line contains an integer, m, denoting the number games Alice plays.
The last line contains m space-separated integers alice[j], the game scores.

Constraints

		1 <= n <= 2 x 10^5
		1 <= m <= 2 x 10^5
		0 <= scores[i] <= 10^9 for 0 <= i < n
		0 <= alice[i] <= 10^9 for 0 <= j < n
		The existing leaderboard, scores, is in descending order.
		Alice's scores, alice, are in ascending order.

Subtask

For 60% of the maximum score:
		1 <= n <= 200
		1 <= m <= 200

Output Format

Print m integers. The j-th integer should indicate Alice's rank after playing the j-th game.

Sample Input 1

7
100 100 50 40 40 20 10
4
5 25 50 120

Sample Output 1

6
4
2
1

Sample Input 2

6
100 90 90 80 75 60
5
50 65 77 90 102

Sample Output 2

6
5
4
2
1
*/

import java.util.Scanner;

public class ClimbingTheLeaderboard {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numberOfPlayers = scanner.nextInt();
		int[] scores = new int[numberOfPlayers];
		
		for (int i = 0; i < numberOfPlayers; i++) {
			scores[i] = scanner.nextInt();
		}
		
		int numberOfGamesPlayed = scanner.nextInt();
		int[] alicesScores = new int[numberOfGamesPlayed];
		
		for (int i = 0; i < numberOfGamesPlayed; i++) {
			alicesScores[i] = scanner.nextInt();
		}
		
		for (int rank : climbingLeaderboard(scores, alicesScores)) {
			System.out.println(rank);
		}
	}
	
	private static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int[] alicesRanks = new int[alice.length];
		int[] leaderboard = new int[scores.length];
		leaderboard[0] = 1;

		for (int i = 1; i < scores.length; i++) {
			if (scores[i] == scores[i - 1]) {
				leaderboard[i] = leaderboard[i - 1];
			} else {
				leaderboard[i] = leaderboard[i - 1] + 1;
			}
		}

		for (int i = 0; i < alice.length; i++){
			int left = 0;
			int right = scores.length - 1;
			int middle;
			System.out.println(alice[i]);
			while (left != right) {
				middle = left + (right - left) / 2;
				
				if (alice[i] > scores[middle]) {
					right = middle;
				} else if (alice[i] < scores[middle]){
					left = middle + 1;
				} else if (alice[i] == scores[middle]) {
					left = middle;
					right = middle;
				}
				System.out.println(left + " " + right);
			}

			if (alice[i] < scores[right]) {
				alicesRanks[i] = leaderboard[right] + 1;
			} else if (alice[i] >= scores[right]) {
				if (leaderboard[right] == 1) {
					alicesRanks[i] = 1;
				} else {
					alicesRanks[i] = leaderboard[right];
				}
			}
		}

		return alicesRanks;
	}
}