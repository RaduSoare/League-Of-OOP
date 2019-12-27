package player.strategy;

import common.player.PConstants;
import common.player.strategy.PyromancerStrategyConstants;
import player.Player;

public class PyromancerStrategy implements PlayerStrategy {


  @Override
  public void damageStrategy(Player player) {
    player.setHP(Math.round(player.getHP() * PyromancerStrategyConstants.DS_HP_MODIFIER));
    player.setStrategyDamageModifier(player.getStrategyDamageModifier()
        + PyromancerStrategyConstants.DS_DMG_MODIFIER);
  }

  @Override
  public void hpStrategy(Player player) {
    player.setHP(Math.round(player.getHP() * PyromancerStrategyConstants.HS_HP_MODIFIER));
    player.setStrategyDamageModifier(player.getStrategyDamageModifier()
        + PyromancerStrategyConstants.HS_DAMAGE_MODIFIER);
  }

  @Override
  public void strategySelection(Player player) {
    int maxLevelHp = PConstants.PYRO_HP + player.getLevel() * PConstants.PYRO_BONUS_HP;
    if (PyromancerStrategyConstants.DS_LOW_HP_LIMIT * maxLevelHp < player.getHP()
        && player.getHP() < PyromancerStrategyConstants.DS_HIGH_HP_LIMIT * maxLevelHp) {
      damageStrategy(player);
    } else if (player.getHP() < PyromancerStrategyConstants.HS_HIGH_HP_LIMIT * maxLevelHp) {
      hpStrategy(player);
    }

  }

}
