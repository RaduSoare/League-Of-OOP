package main;


import observer.GreatMagician;
import utility.FileReader;
import utility.OutputFinalStats;

public final class Main {

  private Main() {

  }

  public static void main(final String[] args) {


    FileReader fr = new FileReader(args[0], args[1]);
    GreatMagician.setPathOut(args[1]);
    GameDatas gameDatas = fr.readFile();
    GameLogic gameLogic = new GameLogic();
    gameLogic.gameEvolution(gameDatas, args[0], args[1]);
    OutputFinalStats.writeStatsInFile(args[0], args[1], gameDatas);

  }

}
