package main;


import utility.FileReader;

public class Main {

  public static void main(String[] args) {

    String inputPath = "C:\\Users\\radus\\git\\ProiectPOO\\ProiectPoo-Etapa1\\src\\checker\\resources"
        + "\\in\\dense.in";
    String outputPath = "C:\\Users\\radus\\git\\ProiectPOO\\ProiectPoo-Etapa1\\src\\out.txt";
    //FileReader fr = new FileReader(inputPath, outputPath);
    FileReader fr = new FileReader(args[0], args[1]);
    GameDatas gameDatas = fr.readFile();
    GameLogic gameLogic = new GameLogic();
    gameLogic.gameEvolution(gameDatas);
    //OutputFinalStats.showStats(gameDatas);
    //OutputFinalStats.writeStatsInFile(inputPath, outputPath, gameDatas);
    OutputFinalStats.writeStatsInFile(args[0], args[1], gameDatas);



  }

}
