package gameMechanism;

import player.Player;

public class LevelUpCalculator {

  public void computeLevelUp(Player player) {
    HpCalculator hpCalcualtor = new HpCalculator();
    int xpLevelUp = 0;
    do {
      xpLevelUp = 250 + player.getLevel() * 50;
      if(player.getXP() >= xpLevelUp) {
        player.setLevel(player.getLevel() + 1);
        hpCalcualtor.updateHp(player);
      }
    }while(player.getXP() >= xpLevelUp);

  }
}
