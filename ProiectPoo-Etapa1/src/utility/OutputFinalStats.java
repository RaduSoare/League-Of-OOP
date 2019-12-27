package utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    System.out.println("~~ Results ~~");
   // int i = 0;
    for (Player x : gameDatas.getPlayers()) {
      if (x.getHP() > 0) {
        System.out.println(x.getType() + " " + x.getLevel() + " " + x.getXP()
        + " " + x.getHP() + " " + x.getxCoordinate() + " " + x.getyCoordinate());
      } else {
        System.out.println(x.getType() + " " + "dead");
      }
     // i++;
    }

  }
  /*
   * scrie proprietatile jucatorilor in fisierul de iesire
   */

  public static void writeStatsInFile(final String pathIn, final String pathOut,
      final GameDatas gameDatas) {

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut, true));
      writer.append("~~ Results ~~");
      writer.newLine();
      for (Player x : gameDatas.getPlayers()) {

        if (x.getHP() > 0) {
          String line = x.getType() + " " + x.getLevel() + " " + x.getXP() + " " + x.getHP()
          + " " + x.getxCoordinate() + " " + x.getyCoordinate();
          writer.append(line);
          writer.newLine();
        } else {
            String line = x.getType() + " " + "dead";
            writer.append(line);
            writer.newLine();
        }
      }
      writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
