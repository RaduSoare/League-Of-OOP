package gamemechanism;

import common.player.KConstants;
import common.player.PConstants;
import common.player.RConstants;
import common.player.WConstants;
import player.Player;

public class MaxHpCalculator {

  public int computeMaxHpP(Player x) {
    return PConstants.PYRO_HP + x.getLevel() * PConstants.PYRO_BONUS_HP;
  }

  public int computeMaxHpK(Player x) {
    return KConstants.KNIGHT_HP + x.getLevel() * KConstants.KNIGHT_BONUS_HP;
  }

  public int computeMaxHpW(Player x) {
    return WConstants.WIZARD_HP + x.getLevel() * WConstants.WIZARD_BONUS_HP;
  }

public int computeMaxHpR(Player x) {
  return RConstants.ROGUE_HP + x.getLevel() * RConstants.ROGUE_BONUS_HP;
  }
}
