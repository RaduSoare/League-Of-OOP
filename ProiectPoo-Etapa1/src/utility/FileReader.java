package utility;

import java.util.LinkedList;

import common.Constants;
import fileio.FileSystem;
import main.GameDatas;
import player.Player;
import player.PlayerFactory;

public class FileReader {

  private final String inputPath;
  private final String outputPath;

  public FileReader(final String inputPath, final String outputPath) {

    super();
    this.inputPath = inputPath;
    this.outputPath = outputPath;
  }

  public GameDatas readFile() {
    int n = 0, m = 0;
    int numberOfPlayers = 0;
    int numberOfRounds = 0;
    char[] directions = new char[Constants.getMaxMoves()];
    char[][] realm = new char[Constants.getMaxLength()][Constants.getMaxLength()];
    LinkedList<Player> players = new LinkedList<Player>();

    int xCoord = 0, yCoord = 0;
    String playerType;

    try {
      FileSystem fs = new FileSystem(inputPath, outputPath);
      n =  fs.nextInt();
      m = fs.nextInt();
      int index = 0;

      for (int i = 0; i < n; i++) {
       String temp = fs.nextWord();
       for (int j = 0; j < temp.length(); j++) {
         realm[i][j] = temp.charAt(j);
       }
      }

      numberOfPlayers = fs.nextInt();
      for (int i = 0; i < numberOfPlayers; i++) {
        playerType = fs.nextWord();
        xCoord = fs.nextInt();
        yCoord = fs.nextInt();
        PlayerFactory playerFactory = PlayerFactory.getInstance();
        players.add(playerFactory.createPlayer(playerType, Constants.getFullHp(), 0, xCoord, yCoord, realm[xCoord][yCoord]));
      }

      numberOfRounds=fs.nextInt();
      index = 0;
      for(int i = 0; i < numberOfRounds; i++) {
        String temp = fs.nextWord();
        for (int j = 0; j < temp.length(); j++) {
          directions[index] = temp.charAt(j);
          index++;
        }
      }




    } catch (Exception e1) {
        e1.printStackTrace();
    }



    return new GameDatas(n, m, realm, numberOfPlayers, players, numberOfRounds, directions);
  }

}
