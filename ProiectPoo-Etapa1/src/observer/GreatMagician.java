package observer;

import utility.FileLineWriter;

public class GreatMagician implements Observer {

  private static String pathOut;


  public static String getPathOut() {
    return pathOut;
  }


  public static void setPathOut(String pathOut) {
    GreatMagician.pathOut = pathOut;
  }


  @Override
  public final void update(final String message) {
    FileLineWriter.writeLine(message, pathOut);

  }

}
