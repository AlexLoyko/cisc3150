import java.util.*;

public class Main {
  public static void main(String [] args) {
    for (int i = 0; i <= 3; i++)
      new Thread(new CharacterPrinter(i)).start();
  }
}

class CharacterPrinter implements Runnable {
  static Integer curr_char = 65;
  int order;

  public CharacterPrinter(int order) {
    this.order = order;
  }

  public void run() {
    while (curr_char <= 90)
      if (((curr_char-1) % 4) == order) {
        System.out.println("Thread " + (order + 1) + " printed " + (char)((int)curr_char));
        curr_char++;
      }
  }
}
