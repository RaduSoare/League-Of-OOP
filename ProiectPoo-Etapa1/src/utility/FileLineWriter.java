package utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public final class FileLineWriter {

  private FileLineWriter() {

  }


  /*
   * Scrie in fisier linia primita ca parametru.
   */
  public static void writeLine(final String line, final String pathOut) {

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut, true));
      writer.append(line);
      writer.newLine();
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
