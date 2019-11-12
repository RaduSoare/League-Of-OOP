package main;

import java.util.LinkedList;

import player.Player;

public class GameDatas {
  private final int N;
  private final int M;
  private final char[][] realm;
  private final int numberOfPlayers;
  private LinkedList<Player> players;
  private final int numberOfRounds;
  private final char[] directions;

  public GameDatas(int n, int m, char[][] realm, int numberOfPlayers,
      LinkedList<Player> players, int numberOfRounds, char[] directions) {

    super();
    N = n;
    M = m;
    this.realm = realm;
    this.numberOfPlayers = numberOfPlayers;
    this.players = players;
    this.numberOfRounds = numberOfRounds;
    this.directions = directions;
  }

  public char[][] getRealm() {
    return realm;
  }

  public LinkedList<Player> getPlayers() {
    return players;
  }

  public void setPlayers(LinkedList<Player> players) {
    this.players = players;
  }

  public int getN() {
    return N;
  }

  public int getM() {
    return M;
  }

  public int getNumberOfPlayers() {
    return numberOfPlayers;
  }

  public int getNumberOfRounds() {
    return numberOfRounds;
  }

  public char[] getDirections() {
    return directions;
  }









}
