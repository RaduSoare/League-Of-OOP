package gamemechanism;

import common.player.Constants;
import observer.GreatMagician;
import player.Player;
import utility.FullNameProvider;

public class LevelUpCalculator {

  public final void computeLevelUp(final Player player) {
    HpCalculator hpCalculator = new HpCalculator();
    GreatMagician greatMagician = new GreatMagician();

    int xpLevelUp = 0;
    do {

      xpLevelUp = Constants.LEVEL_STEP + player.getLevel() * Constants.LEVEL_NEXT_STEP;
      if (player.getXP() >= xpLevelUp) {
        int oldLevel = player.getLevel();

        player.setLevel(player.getLevel() + 1);
        hpCalculator.updateHp(player);

        int newLevel = player.getLevel();
        // notificare observer
           if(oldLevel != newLevel) {
             player.notifyUpdate(greatMagician, FullNameProvider.getFullName(player.getType()) + " "
           + player.getIndex() + " reached level " + player.getLevel());
           }
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
