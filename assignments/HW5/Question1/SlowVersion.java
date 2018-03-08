import java.util.Random;

class SlowVersion {
  public static void main(String... args) {
    long before = System.currentTimeMillis();

    final long FOUR_BILLION = (long) 4e9;
    final int radius = 1;
    long insideCount = 0;
    Random rand = new Random();

    for (long i = 0; i < FOUR_BILLION; i++) {
      double x = rand.nextDouble() * radius;
      double y = rand.nextDouble() * radius;

      double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

      if (distance <= radius)
        insideCount++;
    }

    // this is equvalent to PI/4
    double ratio = (double) insideCount / FOUR_BILLION;
    // times 4 gives me approximation of PI
    double pseudoPi = ratio * 4;

    System.out.println("Calculated PI: " + pseudoPi);
    System.out.println("Execution time: " + (System.currentTimeMillis() - before) + "ms");
  }
}
