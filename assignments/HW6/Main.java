import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String... args) {

    Scanner input = new Scanner(System.in);
    System.out.println("Please enter positive integer N for the NxN chess board:");
    int n = input.nextInt();
    NQueensSolutionsFinder sol = new NQueensSolutionsFinder(n);
    ArrayList<ArrayList<String>> answer = sol.solve();

    if(answer.size() == 0) {
      System.out.println("No solution exists...");
      System.exit(0);
    }

    for (int i = 0; i < answer.size(); i++) {
      System.out.println("Solution " + (i+1));

      for (int j = 0; j < answer.get(i).size(); j++)
        System.out.println(answer.get(i).get(j));

      System.out.println();
    }
  }
}


// my implementation of NQueens Problem Solver
// inspired by https://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
class NQueensSolutionsFinder {
    private ArrayList<ArrayList<String>> answer;
    private String [][] board;
    private int n;

    public NQueensSolutionsFinder(int dimension) {
      this.n = dimension;
      this.board = new String[dimension][dimension];
      this.answer = new ArrayList<ArrayList<String>>();
    }

    public ArrayList<ArrayList<String>> solve() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = ".";

        solveNQ(0);

        return answer;
    }

    private boolean isSafe(int row, int col) {
        // check the left part of the row
        for (int i = 0; i < col; i++)
            if (board[row][i].compareTo("Q") == 0)
                return false;

        // check the upper diagonal on the left
        int r = row - 1, c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c].compareTo("Q") == 0)
                return false;
            r--;
            c--;
        }

        r = row + 1;
        c = col - 1;

        //check the bottom diagonal on the left
        while (r < n && c >= 0) {
            if (board[r][c].compareTo("Q") == 0)
                return false;
            r++;
            c--;
        }

        // if all the checks have passed, it is safe
        return true;
    }

    private ArrayList<String> saveBoard () {
        ArrayList<String> boardState = new ArrayList<String>();

        for (int row = 0; row < n; row++) {
            String rowString = "";
            for (int col = 0; col < n; col++)
                rowString += board[row][col];

            boardState.add(rowString);
        }

        return boardState;
    }

    private void solveNQ(int col) {
        if (col == n) {
            answer.add(saveBoard());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(i, col)) {
                board[i][col] = "Q";
                solveNQ(col + 1);
                board[i][col] = ".";
            }
        }
    }
}
