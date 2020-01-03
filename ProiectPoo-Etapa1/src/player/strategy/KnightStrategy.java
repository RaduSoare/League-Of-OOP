package player.strategy;

import common.player.KConstants;
import common.player.strategy.KnightStrategyConstants;
import player.Player;

public class KnightStrategy implements PlayerStrategy {


  @Override
  public final void damageStrategy(final Player player) {

    player.setHP(Math.round(player.getHP() * KnightStrategyConstants.DS_HP_MODIFIER));
    player.setStrategyDamageModifier(player.getStrategyDamageModifier()
        + KnightStrategyConstants.DS_DMG_MODIFIER);
  }

  @Override
  public final void hpStrategy(final Player player) {
    player.setHP(Math.round(player.getHP() * KnightStrategyConstants.HS_HP_MODIFIER));
    player.setStrategyDamageModifier(player.getStrategyDamageModifier()
        + KnightStrategyConstants.HS_DAMAGE_MODIFIER);
  }

  @Override
  public final void strategySelection(final Player player) {
    int maxLevelHp = KConstants.KNIGHT_HP + player.getLevel() * KConstants.KNIGHT_BONUS_HP;
    if (KnightStrategyConstants.DS_LOW_HP_LIMIT * maxLevelHp < player.getHP()
        && player.getHP() < KnightStrategyConstants.DS_HIGH_HP_LIMIT * maxLevelHp) {
      damageStrategy(player);
    } else if (player.getHP() < KnightStrategyConstants.HS_HIGH_HP_LIMIT * maxLevelHp) {
      hpStrategy(player);
    }

  }

}
