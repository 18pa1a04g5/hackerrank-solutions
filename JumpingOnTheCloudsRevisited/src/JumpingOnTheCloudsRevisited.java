import java.util.Scanner;

public class JumpingOnTheCloudsRevisited {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfClouds = scanner.nextInt();
    int jumpDistance = scanner.nextInt();
    int[] clouds = new int[numberOfClouds];

    for (int i = 0; i < numberOfClouds; i++) {
      clouds[i] = scanner.nextInt();
    }

    System.out.println(jumpingOnClouds(clouds, jumpDistance));
  }

  private static int jumpingOnClouds(int[] c, int k) {
    int energyLevel = 100;
    int energyDrainOnThunderCloud = 2;
    int energyDrainOfJump = 1;
    boolean isBackAtFirstCloud = false;
    int i = 0;

    while (!isBackAtFirstCloud) {
      energyLevel -= (c[i] == 1) ? energyDrainOnThunderCloud + energyDrainOfJump :
          energyDrainOfJump;

      i = (i + k) > c.length - 1 ? (i + k) % c.length : i + k;

      isBackAtFirstCloud = (i == 0);
    }
    return energyLevel;
  }
}
