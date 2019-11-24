package main;

import java.io.IOException;

import fileio.FileSystem;
import player.Player;

public class OutputFinalStats {

  public static void showStats(GameDatas gameDatas) {
    for(Player x : gameDatas.getPlayers()) {
      if(x.getHP() > 0) {
        System.out.println(x.getType() + " " + x.getLevel() + " " + x.getXP() + " " + x.getHP()
         + " " + x.getxCoordinate() + " " + x.getyCoordinate());
      } else {
        System.out.println(x.getType() + " " + "dead");
      }
    }
  }

  public static void writeStatsInFile(String pathIn ,String pathOut, GameDatas gameDatas) {
    try {
      FileSystem fileSystem = new FileSystem(pathIn, pathOut);
      for(Player x : gameDatas.getPlayers()) {
        if(x.getHP() > 0) {
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
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
