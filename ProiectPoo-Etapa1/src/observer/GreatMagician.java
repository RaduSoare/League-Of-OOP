package observer;

import utility.FileLineWriter;

public class GreatMagician implements Observer {

  public static String pathOut;

  @Override
  public void update(String message) {
    //System.out.println(message);
    FileLineWriter.writeLine(message, pathOut);

  }

}
