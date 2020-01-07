package gamemechanism;

import common.player.Constants;
import player.Player;

public class XpCalculator {

  /*
   * Calculeaza XP-ul jucatorului ce a invins intr-o lupta.
   */
  public final void computeXp(final Player winner, final int level) {
    int newXpWinner = winner.getXP() + Math.max(0, Constants.XP_FORMULA_TERM1
        - (winner.getLevel() - level) * Constants.XP_FORMULA_TERM2);
    winner.setXP(newXpWinner);
  }
}
