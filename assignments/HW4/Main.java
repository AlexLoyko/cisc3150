import java.util.Scanner;
import java.util.HashSet;

class Main {
  public static void main(String [] args) {
    Scanner input = new Scanner(System.in);
    int nRows = input.nextInt();
    String [][] arr = new String[nRows][];
    int [] maxL = new int[nRows];
    int [] currRowPos = new int[nRows];
    int numOutcomes = 1;

    // use a set to help show the correctness of my solution
    HashSet<String> test = new HashSet<String>();

    for (int i = 0; i < nRows; i++) {
      int rowLength = input.nextInt();
      arr[i] = new String[rowLength];
      maxL[i] = rowLength;

      //update the number of outcomes
      numOutcomes *= rowLength;

      // fill in the 2D array
      for (int j = 0; j < rowLength; j++) {
        arr[i][j] = input.next();
      }
    }

    // allocate space for {numberOutcomes} strings to hold the possible combinations
    String [] outcomes = new String [numOutcomes];

    // set each string to empty; by default set to "null"
    for (int i = 0; i < outcomes.length; i++)
      outcomes[i] = "";

    int count = 0;
    int t = 0;

    // we know exactly how many times to iterate
    while (count < numOutcomes) {
      for (int j = 0; j < nRows; j++)
        outcomes[count] += arr[j][currRowPos[j]];

      // the twist of this algorithm; my little masterpiece
      for (t = nRows - 1; t >= 0; t--) {
        if (currRowPos[t] + 1 != maxL[t]) {
          currRowPos[t] += 1;
          break;
        } else {
          currRowPos[t] = 0;
        }
      }

      count++;
    }

    // print the results, add the entries to the set
    for (int i = 0; i < outcomes.length; i++) {
      System.out.println(outcomes[i]);
      test.add(outcomes[i]);
    }

    // test for correctness
    // knowing we should have numOutcomes different combinations
    // the size of the set should match that numberOutcomes
    // prints "true" if the size of the set matches the number of outcomes
    System.out.println("\nSize of the set matches the size of the expected outcomes?");
    System.out.println(test.size() == numOutcomes);
  }
}
