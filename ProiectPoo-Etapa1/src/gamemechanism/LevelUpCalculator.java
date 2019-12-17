package gamemechanism;

import common.player.Constants;
import player.Player;

public class LevelUpCalculator {

  public final void computeLevelUp(final Player player) {
    HpCalculator hpCalcualtor = new HpCalculator();
    int xpLevelUp = 0;
    do {
      xpLevelUp = Constants.LEVEL_STEP + player.getLevel() * Constants.LEVEL_NEXT_STEP;
      if (player.getXP() >= xpLevelUp) {
        player.setLevel(player.getLevel() + 1);
        hpCalcualtor.updateHp(player);
      }
    } while (player.getXP() >= xpLevelUp);

  }

  public final int xpForNextLevel(final int oldXp) {

    int tempXp = Constants.LEVEL_STEP;
    while(true) {
      if(tempXp < oldXp) {
        tempXp += Constants.LEVEL_NEXT_STEP;
      } else {
        return tempXp;
      }
    }
  }
}
