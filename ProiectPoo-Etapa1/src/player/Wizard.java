package player;

import angels.Angel;
import common.player.Constants;
import common.player.KConstants;
import common.player.PConstants;
import common.player.RConstants;
import common.player.WConstants;

public class Wizard extends Player {

  public Wizard(final String type, final int hP, final int xP, final int xCoordinate,
      final int yCoordinate, final char terrain) {
    super(type, hP, xP, xCoordinate, yCoordinate, terrain);

  }

  @Override
  public final void fightsWith(final Player player) {
    player.fight(this);
  }

  @Override
  public final void fight(final Pyromancer pyromancer) {

    int enemyMaxHp = PConstants.PYRO_HP + PConstants.PYRO_BONUS_HP * pyromancer.getLevel();
    int drain = drainDamage(enemyMaxHp,  pyromancer.getHP(), WConstants.DRAIN_P_MODIFIER);
    int deflect = deflectDamage(WConstants.DEFLECT_P_MODIFIER);
    int damage = drain + deflect;
    this.setDamageGiven(damage);
  }

  @Override
  public final void fight(final Knight knight) {

    int enemyMaxHp = KConstants.KNIGHT_HP + KConstants.KNIGHT_BONUS_HP * knight.getLevel();
    int drain = drainDamage(enemyMaxHp,  knight.getHP(), WConstants.DRAIN_K_MODIFIER);
    int deflect = deflectDamage(WConstants.DEFLECT_K_MODIFIER);
    int damage = drain + deflect;
    this.setDamageGiven(damage);
  }

  @Override
  public final void fight(final Wizard wizard) {

    int enemyMaxHp = WConstants.WIZARD_HP + WConstants.WIZARD_BONUS_HP * wizard.getLevel();
    int drain = drainDamage(enemyMaxHp, wizard.getHP(), WConstants.DRAIN_W_MODIFIER);
    int deflect = 0;
    int damage = drain + deflect;
    this.setDamageGiven(damage);
  }

  @Override
  public final void fight(final Rogue rogue) {

    int enemyMaxHp = RConstants.ROGUE_HP + RConstants.ROGUE_BONUS_HP * rogue.getLevel();
    int drain = drainDamage(enemyMaxHp,  rogue.getHP(), WConstants.DRAIN_R_MODIFIER);
    int deflect = deflectDamage(WConstants.DEFLECT_R_MODIFIER);
    int damage = drain + deflect;
    this.setDamageGiven(damage);

  }

  public final float landModifier(final char terrainType) {

    if (terrainType == 'D') {
      return WConstants.WIZARD_LAND_MODIFIER;
    }
    return 1f;
  }

  public final int drainDamage(final int enemyMaxHp, final int enemyHp, final float drainModifier) {

    int baseHp = (int) Math.min(Constants.HP_BONUS_FORMULA * enemyMaxHp, enemyHp);
    float percent = WConstants.DRAIN_PERCENT + WConstants.DRAIN_PERCENT_BONUS * this.getLevel();
    percent = percent * drainModifier * landModifier(getCurrentTerrain());
    int drain = Math.round(percent * baseHp);
    return drain;
  }

  public final int deflectDamage(final float deflectModifier) {

    int deflect = Math.round(this.getDamageTaken() * (WConstants.DEFLECT_PERCENT
        + WConstants.DEFLECT_PERCENT_BONUS * this.getLevel()));
    deflect = Math.round(deflect * deflectModifier * landModifier(getCurrentTerrain()));

    return deflect;
  }

  @Override
  public void getBuff(Angel angel) {
    // TODO Auto-generated method stub
    angel.buff(this);
  }

}
