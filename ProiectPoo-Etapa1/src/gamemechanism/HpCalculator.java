package gamemechanism;

import common.player.KConstants;
import common.player.PConstants;
import common.player.RConstants;
import common.player.WConstants;
import player.Player;

public class HpCalculator {

  public final void updateHp(final Player player) {
    int baseHp = 0, bonusHp = 0;
    if (player.getType().equals("W")) {
        baseHp = WConstants.WIZARD_HP;
        bonusHp = WConstants.WIZARD_BONUS_HP;

    } else if (player.getType().equals("R")) {
        baseHp = RConstants.ROGUE_HP;
        bonusHp = RConstants.ROGUE_BONUS_HP;

    } else if (player.getType().equals("P")) {
        baseHp = PConstants.PYRO_HP;
        bonusHp = PConstants.PYRO_BONUS_HP;

    } else if (player.getType().equals("K")) {
        baseHp = KConstants.KNIGHT_HP;
        bonusHp = KConstants.KNIGHT_BONUS_HP;
    }

    player.setHP(baseHp + bonusHp * player.getLevel());
  }
}
