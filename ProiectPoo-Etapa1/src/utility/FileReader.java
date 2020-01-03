package utility;

import java.util.ArrayList;
import java.util.LinkedList;

import angels.Angel;
import angels.AngelFactory;
import common.player.Constants;
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

  public final GameDatas readFile() {
    int n = 0, m = 0;
    int indexPlayer = 0;
    int numberOfPlayers = 0;
    int numberOfRounds = 0;
    char[] directions = new char[Constants.MAX_MOVES];
    char[][] realm = new char[Constants.MAX_LENGTH][Constants.MAX_LENGTH];
    LinkedList<Player> players = new LinkedList<Player>();
    ArrayList<LinkedList<Angel>> angels = new ArrayList<LinkedList<Angel>>();

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
        players.add(playerFactory.createPlayer(playerType, 0, 0, xCoord, yCoord,
            realm[xCoord][yCoord], indexPlayer));
        indexPlayer++;
      }

      numberOfRounds = fs.nextInt();
      index = 0;
      for (int i = 0; i < numberOfRounds; i++) {
        String temp = fs.nextWord();
        for (int j = 0; j < temp.length(); j++) {
          directions[index] = temp.charAt(j);
          index++;
        }
      }


      for (int i = 0; i < numberOfRounds; i++) {
        LinkedList<Angel> tempListOfAngels = new LinkedList<Angel>();
        int tempNoOfAngels = fs.nextInt();
        for (int j = 1; j <= tempNoOfAngels; j++) {
          String[] angel = fs.nextWord().split(",");

          AngelFactory angelFactory = AngelFactory.getInstance();
          tempListOfAngels.add(angelFactory.createAngel(Integer.parseInt(angel[1]),
              Integer.parseInt(angel[2]), angel[0]));
        }
        angels.add(i, tempListOfAngels);

      }

    } catch (Exception e1) {
        e1.printStackTrace();
    }



    return new GameDatas(n, m, realm, numberOfPlayers, players, numberOfRounds,
        directions, angels);
  }

}
