package utility;

import java.io.IOException;

import fileio.FileSystem;
import main.GameDatas;
import player.Player;

public final class OutputFinalStats {

  private OutputFinalStats() {

  }
  /*
   * afiseaza proprietatile jucatorilor la Stdout
   * nefolosit in codul pentru prima tema
   * pastrat pentru debugging in etapa 2
   */
  public static void showStats(final GameDatas gameDatas) {
    int i = 0;
    for (Player x : gameDatas.getPlayers()) {
      if (x.getHP() > 0) {
        System.out.println(i + ": " + x.getType() + " " + x.getLevel() + " " + x.getXP()
        + " " + x.getHP() + " " + x.getxCoordinate() + " " + x.getyCoordinate());
      } else {
        System.out.println(i + ": " + x.getType() + " " + "dead");
      }
      i++;
    }

  }
  /*
   * scrie proprietatile jucatorilor in fisierul de iesire
   */
  public static void writeStatsInFile(final String pathIn, final String pathOut,
      final GameDatas gameDatas) {

    try {
      FileSystem fileSystem = new FileSystem(pathIn, pathOut);
      for (Player x : gameDatas.getPlayers()) {

        if (x.getHP() > 0) {
          String line = x.getType() + " " + x.getLevel() + " " + x.getXP() + " " + x.getHP()
          + " " + x.getxCoordinate() + " " + x.getyCoordinate();
          fileSystem.writeWord(line);
          fileSystem.writeNewLine();
        } else {
            String line = x.getType() + " " + "dead";
            fileSystem.writeWord(line);
            fileSystem.writeNewLine();

        }
      }
      fileSystem.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
