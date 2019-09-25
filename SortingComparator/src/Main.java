/**
 * Implement the compare method to sort players based on their score in descending order, or if
 * their scores are equal, then sort them by their name in ascending order.
 *
 * Sample input:
 * 5
 * amy 100
 * david 100
 * heraldo 50
 * aakansha 75
 * aleksa 150
 *
 * Sample output:
 *
 * aleksa 150
 * amy 100
 * david 100
 * aakansha 75
 * heraldo 50
 */

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    Player[] player = new Player[n];
    Checker checker = new Checker();

    for(int i = 0; i < n; i++){
      player[i] = new Player(scan.next(), scan.nextInt());
    }
    scan.close();

    Arrays.sort(player, checker);
    for(int i = 0; i < player.length; i++){
      System.out.printf("%s %s\n", player[i].name, player[i].score);
    }
  }
}

class Player {
  String name;
  int score;

  Player(String name, int score) {
    this.name = name;
    this.score = score;
  }
}

class Checker implements Comparator<Player> {
  // complete this method
  public int compare(Player a, Player b) {
    if (a.score - b.score > 0) {
      return -1;
    } else if (a.score - b.score == 0) {
      return a.name.compareTo(b.name);
    }
    return 1;
  }
}