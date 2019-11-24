package gameMechanism;

import player.Player;

public class XpCalculator {

  public void computeXp(Player winner, Player loser) {
    int newXpWinner = winner.getXP() + Math.max(0, 200 - (winner.getLevel() - loser.getLevel()) * 40);
    winner.setXP(newXpWinner);
  }
}
