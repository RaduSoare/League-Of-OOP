package main;

import utility.FileReader;

public class Main {

  public static void main(String[] args) {

    System.out.println("merge");
    String inputPath = "C:\\Users\\radus\\git\\ProiectPOO\\ProiectPoo-Etapa1\\checker\\checker\\resources\\in\\3x3.in";
    String outputPath = "C:\\Users\\radus\\Desktop\\out.txt";
    FileReader fr = new FileReader(inputPath, outputPath);
    GameDatas gameDatas = fr.readFile();
    GameLogic gameLogic = new GameLogic();
    gameLogic.gameEvolution(gameDatas);

  }

}
