package main;


import utility.FileReader;

public final class Main {

  private Main() {

  }

  public static void main(final String[] args) {

    String in = "C:\\Users\\radus\\git\\ProiectPOO\\ProiectPoo-Etapa1\\src\\checker\\"
        + "resources\\in\\fightKPV.in";
    String out = "test.out";
    FileReader fr = new FileReader(in, out);
    //FileReader fr = new FileReader(args[0], args[1]);
    GameDatas gameDatas = fr.readFile();
    GameLogic gameLogic = new GameLogic();
    gameLogic.gameEvolution(gameDatas);
    //OutputFinalStats.writeStatsInFile(args[0], args[1], gameDatas);
  }

}
