package map;

import java.util.LinkedList;

import player.Player;

public class Terrain {

  private char terrainType;
  private LinkedList<Player> playersOnTerrain;

  public Terrain() {
    super();
    this.playersOnTerrain = new LinkedList<Player>();
  }

  public Terrain(final char terrainType, final LinkedList<Player> playersOnTerrain) {
    super();
    this.terrainType = terrainType;
    this.playersOnTerrain = playersOnTerrain;
  }

  public final LinkedList<Player> getPlayersOnTerrain() {
    return playersOnTerrain;
  }

  public final void setPlayersOnTerrain(final LinkedList<Player> playersOnTerrain) {
    this.playersOnTerrain = playersOnTerrain;
  }
  public final void setTerrainType(final char terrainType) {
    this.terrainType = terrainType;
  }
  public final char getTerrainType() {
    return terrainType;
  }





}
