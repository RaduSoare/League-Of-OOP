package map;

import java.util.LinkedList;

import player.Player;

public class Map {

  private static Map instance = null;
  private Map() {}

  public static Map getInstance() {
    if(instance == null) {
      instance  = new Map();
    }
    return instance;
  }

  public Terrain[][] createMap(char[][] realm, LinkedList<Player> players, int N, int M) {
    Terrain[][] map = new Terrain[N][M];
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        map[i][j] = new Terrain();
        map[i][j].setTerrainType(realm[i][j]);
      }
    }

    for(Player x : players) {
      map[x.getxCoordinate()][x.getyCoordinate()].getPlayersOnTerrain().add(x);
    }
    return map;
  }


}
