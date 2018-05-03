import java.io.*;
import java.util.*;
import java.io.IOException;

public class LS {
  final static String tripod = "\u251c";
  final static String horiz = "\u2500";
  final static String vert = "\u2502";
  final static String twopod = "\u2514";
  private static BufferedWriter writer;

  public static void main(String... args) {
    if (args.length == 0)
      throw new IllegalArgumentException("No directory was provided!");

    if (args.length > 1)
      throw new IllegalArgumentException("Too many arguments! The application is expecting only one argument - the path to the directory to start from!");

    String rootDir = args[0];
    File file = new File(rootDir);

    try {
       writer = new BufferedWriter(new FileWriter("./dir_tree.txt"));
       walkLevel(file, 0, true);
       writer.close();
    } catch(IOException ex) {
      System.out.println("Something went wrong when trying to access dir_tree.txt");
    }
  }

  private static void walkLevel(File file, int level, boolean isLastChild) {
    String outputLine = "";
    if (level > 0) {
      for (int i = 0; i < level - 1; i++)
        outputLine += vert + "   ";

      outputLine += (isLastChild && file.listFiles() == null ? twopod : tripod) + horiz + horiz + " ";
    }

    outputLine += file.getName() + "\n";

    try {
      writer.write(outputLine);
    } catch(IOException ex) {
      System.out.println("Something went wrong when trying to write to dir_tree.txt");
    }

    if (file.isFile())
      return;

    File [] currentL = file.listFiles();

    ArrayList<File> dirs = new ArrayList<>();
    ArrayList<File> files = new ArrayList<>();

    for (int i = 0; i < currentL.length; i++)
      if (currentL[i].isFile())
        files.add(currentL[i]);
      else
        dirs.add(currentL[i]);

    Collections.sort(files, (f1, f2) -> f1.getName().compareTo(f2.getName()));
    Collections.sort(dirs, (f1, f2) -> f1.getName().compareTo(f2.getName()));

    ArrayList<File> merged = dirs;
    merged.addAll(files);

    for (int i = 0; i < merged.size(); i++)
      walkLevel(merged.get(i), level + 1, i == merged.size() - 1);
  }
}
