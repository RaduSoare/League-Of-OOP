package player.strategy;

import common.player.WConstants;
import common.player.strategy.WizardStrategyConstants;
import player.Player;

public class WizardStrategy implements PlayerStrategy{

  @Override
  public void damageStrategy(Player player) {
    player.setHP(Math.round(player.getHP() * WizardStrategyConstants.DS_HP_MODIFIER));
    player.setStrategyDamageModifier(player.getStrategyDamageModifier()
        + WizardStrategyConstants.DS_DMG_MODIFIER);
  }

  @Override
  public void hpStrategy(Player player) {
    player.setHP(Math.round(player.getHP() * WizardStrategyConstants.HS_HP_MODIFIER));
    player.setStrategyDamageModifier(player.getStrategyDamageModifier()
        + WizardStrategyConstants.HS_DAMAGE_MODIFIER);
  }

  @Override
  public void strategySelection(Player player) {
    int maxLevelHp = WConstants.WIZARD_HP + player.getLevel() * WConstants.WIZARD_BONUS_HP;
    if (WizardStrategyConstants.DS_LOW_HP_LIMIT * maxLevelHp < player.getHP()
        && player.getHP() < WizardStrategyConstants.DS_HIGH_HP_LIMIT * maxLevelHp) {
      damageStrategy(player);
    } else if (player.getHP() < WizardStrategyConstants.HS_HIGH_HP_LIMIT * maxLevelHp) {
      hpStrategy(player);
    }

  }



}
