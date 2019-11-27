package map;

import java.util.LinkedList;

import player.Player;

public final class Map {
/*
 * Singleton Pattern pentru crearea hartii.
 */
  private static Map instance = null;
  private Map() { }

  public static Map getInstance() {
    if (instance == null) {
      instance  = new Map();
    }
    return instance;
  }
  /*
   * primeste o matrice reprezentand harta si o lista de jucatori
   * asgineaza fiecarui teren tipul specificat in input
   * aseaza jucatorii pe harta
   */
  public Terrain[][] createMap(final char[][] realm, final LinkedList<Player> players,
      final int n, final int m) {

    Terrain[][] map = new Terrain[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        map[i][j] = new Terrain();
        map[i][j].setTerrainType(realm[i][j]);
      }
    }

    for (Player x : players) {
      map[x.getxCoordinate()][x.getyCoordinate()].getPlayersOnTerrain().add(x);
    }
    return map;
  }


}
