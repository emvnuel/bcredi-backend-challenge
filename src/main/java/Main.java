import mensageria.Solution;

import java.util.*;
import java.nio.file.*;

public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("Starting tests...");

    String[] inputFiles = {
      "./src/main/resources/test/input/input000.txt",
      "./src/main/resources/test/input/input001.txt",
      "./src/main/resources/test/input/input002.txt",
      "./src/main/resources/test/input/input003.txt",
      "./src/main/resources/test/input/input004.txt",
      "./src/main/resources/test/input/input005.txt",
      "./src/main/resources/test/input/input006.txt",
      "./src/main/resources/test/input/input007.txt",
      "./src/main/resources/test/input/input008.txt",
      "./src/main/resources/test/input/input009.txt",
      "./src/main/resources/test/input/input010.txt",
//      "./src/main/resources/test/input/input011.txt",
//      "./src/main/resources/test/input/input012.txt"
    };

    String[] outputFiles = {
      "./src/main/resources/test/output/output000.txt",
      "./src/main/resources/test/output/output001.txt",
      "./src/main/resources/test/output/output002.txt",
      "./src/main/resources/test/output/output003.txt",
      "./src/main/resources/test/output/output004.txt",
      "./src/main/resources/test/output/output005.txt",
      "./src/main/resources/test/output/output006.txt",
      "./src/main/resources/test/output/output007.txt",
      "./src/main/resources/test/output/output008.txt",
      "./src/main/resources/test/output/output009.txt",
      "./src/main/resources/test/output/output010.txt",
//      "./src/main/resources/test/output/output011.txt",
//      "./src/main/resources/test/output/output012.txt"
    };

    for(int i = 0; i <= outputFiles.length - 1; ++i) {
      Path inputPath = Paths.get(inputFiles[i]);
      Path outputPath = Paths.get(outputFiles[i]);

      List<String> inputLines = Files.readAllLines(inputPath);
      List<String> outputLines = Files.readAllLines(outputPath);

      if (Solution.processMessages(inputLines).equals(outputLines.get(0))) {
        System.out.println(String.format("Test %s/%s - Passed", i + 1, outputFiles.length));
      } else {
        System.out.println(String.format("Test %s/%s - Failed", i + 1, outputFiles.length));
      }
    }
  }
}
