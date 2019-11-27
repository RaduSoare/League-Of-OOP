package main;

import java.util.LinkedList;

import player.Player;

public class GameDatas {
  private final int n;
  private final int m;
  private final char[][] realm;
  private final int numberOfPlayers;
  private LinkedList<Player> players;
  private final int numberOfRounds;
  private final char[] directions;

  public GameDatas(final int n, final int m, final char[][] realm, final int numberOfPlayers,
      final LinkedList<Player> players, final int numberOfRounds, final char[] directions) {

    super();
    this.n = n;
    this.m = m;
    this.realm = realm;
    this.numberOfPlayers = numberOfPlayers;
    this.players = players;
    this.numberOfRounds = numberOfRounds;
    this.directions = directions;
  }

  public final char[][] getRealm() {
    return realm;
  }

  public final LinkedList<Player> getPlayers() {
    return players;
  }

  public final void setPlayers(final LinkedList<Player> players) {
    this.players = players;
  }

  public final int getN() {
    return n;
  }

  public final int getM() {
    return m;
  }

  public final int getNumberOfPlayers() {
    return numberOfPlayers;
  }

  public final int getNumberOfRounds() {
    return numberOfRounds;
  }

  public final char[] getDirections() {
    return directions;
  }

}
