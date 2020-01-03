
package player;

import angels.Angel;
import common.player.KConstants;
import common.player.PConstants;
import common.player.RConstants;
import common.player.WConstants;

public class Knight extends Player  {

  public Knight(final String type, final int hP, final int xP, final int xCoordinate,
      final int yCoordinate, final char terrain, final int index) {
    super(type, hP, xP, xCoordinate, yCoordinate, terrain, index);
  }

  @Override
  public final void fightsWith(final Player player) {
    player.fight(this);
  }

  @Override
  public final void fight(final Pyromancer pyromancer) {

    int maxHp = PConstants.PYRO_HP + PConstants.PYRO_BONUS_HP * pyromancer.getLevel();
    int damage = getTotalDamage(pyromancer.getLevel(), maxHp, pyromancer.getHP(),
        KConstants.EXECUTE_P_MODIFIER, pyromancer, KConstants.SLAM_P_MODIFIER);
    this.setDamageGiven(damage);
  }

  @Override
  public final void fight(final Knight knight) {

    int maxHp = KConstants.KNIGHT_HP + KConstants.KNIGHT_BONUS_HP * knight.getLevel();
    int damage = getTotalDamage(knight.getLevel(), maxHp, knight.getHP(),
        KConstants.EXECUTE_K_MODIFIER, knight, KConstants.SLAM_K_MODIFIER);
    this.setDamageGiven(damage);
  }

  @Override
  public final void fight(final Wizard wizard) {

    int maxHp = WConstants.WIZARD_HP + WConstants.WIZARD_BONUS_HP * wizard.getLevel();
    int damage = getTotalDamage(wizard.getLevel(), maxHp, wizard.getHP(),
        KConstants.EXECUTE_W_MODIFIER, wizard, KConstants.SLAM_W_MODIFIER);

    wizard.setDamageTaken(Math.round((KConstants.EXECUTE_DAMAGE + KConstants.EXECUTE_DAMAGE_BONUS
        * this.getLevel()) * landModifier(getCurrentTerrain()))
        + getSlamWithoutModifiers(wizard));
    this.setDamageGiven(damage);

  }

  @Override
  public final void fight(final Rogue rogue) {

    int maxHp = RConstants.ROGUE_HP + RConstants.ROGUE_BONUS_HP * rogue.getLevel();
    int damage = getTotalDamage(rogue.getLevel(), maxHp, rogue.getHP(),
        KConstants.EXECUTE_R_MODIFIER, rogue, KConstants.SLAM_R_MODIFIER);
    this.setDamageGiven(damage);
  }
  /*
   * verifica daca eroul se afla pe terenul preferat pentru a aplica modificatorul de teren
   */
  public final float landModifier(final char terrainType) {

    if (terrainType == 'L') {
      return KConstants.KNIGHT_LAND_MODIFIER;
    }
    return 1f;
  }

  public final int getExecuteWithoutModifiers(final int enemylevel, final int enemyMaxHp,
      final int enemyHp) {

    float hpLimitPercent = KConstants.HP_LIMIT + KConstants.HP_LIMIT_MODIFIER * enemylevel;

    if (hpLimitPercent > KConstants.HP_LIMIT) {
      hpLimitPercent = KConstants.HP_LIMIT;
    }

    float hpLimit = hpLimitPercent * enemyMaxHp;
    if (enemyHp < hpLimit) {
      return enemyHp;
    } else {
      return Math.round((KConstants.EXECUTE_DAMAGE + KConstants.EXECUTE_DAMAGE_BONUS
      * this.getLevel()) * landModifier(getCurrentTerrain()));
    }
  }

  public final int getExecute(final int enemylevel, final int enemyMaxHp, final int enemyHp,
      final float executeModifier) {

    float modifiers = executeModifier + getStrategyDamageModifier() + getAngelDamageModifier();
    if (executeModifier == 1f) {
      modifiers = 1f;
    }

    return Math.round(getExecuteWithoutModifiers(enemylevel, enemyMaxHp, enemyHp)
        * modifiers);
  }

  public final int getSlamWithoutModifiers(final Player enemy) {

    enemy.setParalysed(true);
    enemy.setOvertimeDuration(1);
    return Math.round((KConstants.SLAM_DAMAGE + KConstants.SLAM_DAMAGE_BONUS
        * this.getLevel()) * landModifier(getCurrentTerrain()));
  }

  public final int getSlam(final Player enemy, final float slamModifier) {

    return Math.round(getSlamWithoutModifiers(enemy)
        * (slamModifier + getStrategyDamageModifier() + getAngelDamageModifier()));
  }

  public final int getTotalDamage(final int enemylevel, final int enemyMaxHp, final int enemyHp,
      final float executeModifier, final Player enemy, final float slamModifier) {

    return getExecute(enemylevel, enemyMaxHp, enemyHp, executeModifier)
        + getSlam(enemy, slamModifier);
  }

  @Override
  public final void getBuff(final Angel angel) {
    angel.buff(this);
  }

}
