package gamemechanism;

import common.player.KConstants;
import common.player.PConstants;
import common.player.RConstants;
import common.player.WConstants;
import player.Player;

public class MaxHpCalculator {

  /*
   * Calculeaza HP-ul maxim pe care il poate avea un jucator in functie de nivel.
   */
  public final int computeMaxHpP(final Player x) {
    return PConstants.PYRO_HP + x.getLevel() * PConstants.PYRO_BONUS_HP;
  }

  public final int computeMaxHpK(final Player x) {
    return KConstants.KNIGHT_HP + x.getLevel() * KConstants.KNIGHT_BONUS_HP;
  }

  public final int computeMaxHpW(final Player x) {
    return WConstants.WIZARD_HP + x.getLevel() * WConstants.WIZARD_BONUS_HP;
  }

public final int computeMaxHpR(final Player x) {
  return RConstants.ROGUE_HP + x.getLevel() * RConstants.ROGUE_BONUS_HP;
  }
}
