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

  public Terrain(char terrainType, LinkedList<Player> playersOnTerrain) {
    super();
    this.terrainType = terrainType;
    this.playersOnTerrain = playersOnTerrain;
  }

  public LinkedList<Player> getPlayersOnTerrain() {
    return playersOnTerrain;
  }

  public void setPlayersOnTerrain(LinkedList<Player> playersOnTerrain) {
    this.playersOnTerrain = playersOnTerrain;
  }
  public void setTerrainType(char terrainType) {
    this.terrainType = terrainType;
  }
  public char getTerrainType() {
    return terrainType;
  }





}
