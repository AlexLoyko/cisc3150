import java.util.Random;

class OptimizedVersion {
  public static void main(String... args) {
    long before = System.currentTimeMillis();

    final long FOUR_BILLION = (long) 4e9;
    final int cores = Runtime.getRuntime().availableProcessors();
    final int radius = 1;
    long insideCount = 0;
    long numPointsPerThread = FOUR_BILLION / cores;
    Worker [] threads = new Worker[cores];

    for (int i = 0; i < threads.length; i++) {
      if (i == cores - 1)
        threads[i] = new Worker(radius, numPointsPerThread + FOUR_BILLION % cores);
      else
        threads[i] = new Worker(radius, numPointsPerThread);

      threads[i].start();
    }

    for (int i = 0; i < threads.length; i++) {
      try {
         threads[i].join();
      } catch (InterruptedException e) {}

      insideCount += threads[i].getInsideCount();
    }

    double ratio = (double) insideCount / FOUR_BILLION;
    double pseudoPi = ratio * 4;

    System.out.println("Calculated PI: " + pseudoPi);
    System.out.println("Execution time: " + (System.currentTimeMillis() - before) + "ms");
  }
}

class Worker extends Thread {
  private long insideCount = 0;
  private long numPoints;
  private int radius;
  private Random rand = new Random();

  Worker(int radius, long numPoints) {
    this.radius = radius;
    this.numPoints = numPoints;
  }

  public void run() {
    for (long i = 0; i < numPoints; i++) {
      double x = rand.nextDouble() * radius;
      double y = rand.nextDouble() * radius;

      double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

      if (distance <= radius)
        insideCount++;
    }
  }

  public long getInsideCount() {
    return this.insideCount;
  }
}
