package gameMechanism;

import main.GameDatas;
import map.Terrain;
import player.Player;

public class PlayersMovement {

  public void movePlayers(GameDatas gameDatas, int round, Terrain[][] map) {
    int currentPlayer = 0;
    for(int i = round * gameDatas.getNumberOfPlayers() ; i < (round + 1) * gameDatas.getNumberOfPlayers(); i++) {
      //System.out.println("Player " + currentPlayer + " will move to: " + gameDatas.getDirections()[i]);
      Player tempPlayer = gameDatas.getPlayers().get(currentPlayer);
      if(tempPlayer.isParalysed() == false) {

        if(gameDatas.getDirections()[i] == 'U') {
           tempPlayer.setxCoordinate(tempPlayer.getxCoordinate() - 1);
        } else if(gameDatas.getDirections()[i] == 'D') {
          tempPlayer.setxCoordinate(tempPlayer.getxCoordinate() + 1);
        } else if(gameDatas.getDirections()[i] == 'L') {
          tempPlayer.setyCoordinate(tempPlayer.getyCoordinate() - 1);
        } else if(gameDatas.getDirections()[i] == 'R') {
          tempPlayer.setyCoordinate(tempPlayer.getyCoordinate() + 1);
        }
      }

      currentPlayer++;
    }

    this.updateMap(gameDatas, map);

  }

  public void updateMap(GameDatas gameDatas, Terrain[][] map) {
    //clear the matrix
    for(int i = 0; i < gameDatas.getN(); i++) {
      for(int j = 0; j < gameDatas.getM(); j++) {
        map[i][j].getPlayersOnTerrain().clear();
      }
    }

    for(int i = 0; i < gameDatas.getNumberOfPlayers(); i++) {
      if(gameDatas.getPlayers().get(i).getHP() > 0) {
        Player tempPlayer = gameDatas.getPlayers().get(i);
        map[tempPlayer.getxCoordinate()][tempPlayer.getyCoordinate()].getPlayersOnTerrain().add(tempPlayer);
      }
    }
  }

}
