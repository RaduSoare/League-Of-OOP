package gamemechanism;

import main.GameDatas;
import map.Terrain;
import player.Player;

public class PlayersMovement {

  public final void movePlayers(final GameDatas gameDatas, final int round,
      final Terrain[][] map) {
    int currentPlayer = 0;
    for (int i = round * gameDatas.getNumberOfPlayers();
        i < (round + 1) * gameDatas.getNumberOfPlayers(); i++) {

      Player tempPlayer = gameDatas.getPlayers().get(currentPlayer);
      if (!tempPlayer.isParalysed()) {

          if (gameDatas.getDirections()[i] == 'U' && tempPlayer.getxCoordinate() - 1 > 0) {
             tempPlayer.setxCoordinate(tempPlayer.getxCoordinate() - 1);
             tempPlayer.setCurrentTerrain(map[tempPlayer.getxCoordinate()]
                 [tempPlayer.getyCoordinate()].getTerrainType());

          } else if (gameDatas.getDirections()[i] == 'D') {
            tempPlayer.setxCoordinate(tempPlayer.getxCoordinate() + 1);
            tempPlayer.setCurrentTerrain(map[tempPlayer.getxCoordinate()]
                [tempPlayer.getyCoordinate()].getTerrainType());

          } else if (gameDatas.getDirections()[i] == 'L' && tempPlayer.getyCoordinate() - 1 >= 0) {
            tempPlayer.setyCoordinate(tempPlayer.getyCoordinate() - 1);
            tempPlayer.setCurrentTerrain(map[tempPlayer.getxCoordinate()]
                [tempPlayer.getyCoordinate()].getTerrainType());

          } else if (gameDatas.getDirections()[i] == 'R') {
            tempPlayer.setyCoordinate(tempPlayer.getyCoordinate() + 1);
            tempPlayer.setCurrentTerrain(map[tempPlayer.getxCoordinate()]
                [tempPlayer.getyCoordinate()].getTerrainType());
          }
      }
      currentPlayer++;
    }
    this.updateMap(gameDatas, map);

  }

  public final void updateMap(final GameDatas gameDatas, final Terrain[][] map) {
    // curata matricea
    for (int i = 0; i < gameDatas.getN(); i++) {
      for (int j = 0; j < gameDatas.getM(); j++) {
        map[i][j].getPlayersOnTerrain().clear();
      }
    }

    for (int i = 0; i < gameDatas.getNumberOfPlayers(); i++) {
        Player tempPlayer = gameDatas.getPlayers().get(i);
        map[tempPlayer.getxCoordinate()][tempPlayer.getyCoordinate()].getPlayersOnTerrain().
        add(tempPlayer);
    }
  }

}
