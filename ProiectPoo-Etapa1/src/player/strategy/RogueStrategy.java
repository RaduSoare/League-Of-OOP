package player.strategy;

import common.player.RConstants;
import common.player.strategy.RogueStrategyConstants;
import player.Player;

public class RogueStrategy implements PlayerStrategy {


  @Override
  public final void damageStrategy(final Player player) {
    player.setHP(Math.round(player.getHP() * RogueStrategyConstants.DS_HP_MODIFIER));
    player.setStrategyDamageModifier(player.getStrategyDamageModifier()
        + RogueStrategyConstants.DS_DMG_MODIFIER);
  }

  @Override
  public final void hpStrategy(final Player player) {
    player.setHP(Math.round(player.getHP() * RogueStrategyConstants.HS_HP_MODIFIER));
    player.setStrategyDamageModifier(player.getStrategyDamageModifier()
        + RogueStrategyConstants.HS_DAMAGE_MODIFIER);
  }

  @Override
  public final void strategySelection(final Player player) {
    int maxLevelHp = RConstants.ROGUE_HP + player.getLevel() * RConstants.ROGUE_BONUS_HP;
    if (RogueStrategyConstants.DS_LOW_HP_LIMIT * maxLevelHp < player.getHP()
        && player.getHP() < RogueStrategyConstants.DS_HIGH_HP_LIMIT * maxLevelHp) {
      damageStrategy(player);
    } else if (player.getHP() < RogueStrategyConstants.HS_HIGH_HP_LIMIT * maxLevelHp) {
      hpStrategy(player);
    }

  }

}
