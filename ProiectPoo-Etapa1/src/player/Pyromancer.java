package player;

import angels.Angel;
import common.player.PConstants;

public class Pyromancer extends Player  {



  public Pyromancer(final String type, final int hP, final int xP, final int xCoordinate,
      final int yCoordinate, final char terrain, final int index) {
    super(type, hP, xP, xCoordinate, yCoordinate, terrain, index);
  }

  @Override
  public final void fightsWith(final Player player) {
    player.fight(this);
  }

  @Override
  public final void fight(final Pyromancer pyromancer) {

    int damage = getFireblast(PConstants.FIREBLAST_P_MODIFIER)
        + getIgnite(pyromancer, PConstants.IGNITE_P_MODIFIER);
    this.setDamageGiven(damage);
  }

  @Override
  public final void fight(final Knight knight) {

    int damage = getFireblast(PConstants.FIREBLAST_K_MODIFIER)
        + getIgnite(knight, PConstants.IGNITE_K_MODIFIER);
    this.setDamageGiven(damage);

  }

  @Override
  public final void fight(final Wizard wizard) {

    int damage = getFireblast(PConstants.FIREBLAST_W_MODIFIER)
        + getIgnite(wizard, PConstants.IGNITE_W_MODIFIER);
    wizard.setDamageTaken(Math.round(getFireblastWithoutModifiers()
        + getIgniteWithoutModifiers()));
    this.setDamageGiven(damage);
  }

  @Override
  public final void fight(final Rogue rogue) {

    int damage = getFireblast(PConstants.FIREBLAST_R_MODIFIER)
        + getIgnite(rogue, PConstants.IGNITE_R_MODIFIER);
    this.setDamageGiven(damage);
  }

  /*
   * verifica daca eroul se afla pe terenul preferat pentru a aplica modificatorul de teren
   */
  public final float landModifier(final char terrainType) {

    if (terrainType == 'V') {
      return PConstants.PYRO_LAND_MODIFIER;
    }
    return 1f;
  }

  public final float getFireblastWithoutModifiers() {

    return Math.round((PConstants.FIREBLAST_DAMAGE + PConstants.FIREBLAST_DAMAGE_BONUS
        * this.getLevel()) * landModifier(getCurrentTerrain()));
  }

  public final int getFireblast(final float fireblastModifier) {

    return Math.round(getFireblastWithoutModifiers()
        * (fireblastModifier + getStrategyDamageModifier() + getAngelDamageModifier()));
  }

  public final float getIgniteWithoutModifiers() {

    return Math.round((PConstants.IGNITE_DAMAGE + PConstants.IGNITE_DAMAGE_BONUS
        * this.getLevel()) * landModifier(getCurrentTerrain()));
  }

  public final int getIgnite(final Player enemy, final float igniteModifier) {

    int ignite =  Math.round(getIgniteWithoutModifiers()
        * (igniteModifier + getStrategyDamageModifier() + getAngelDamageModifier()));

    if (enemy.getOvertimeDuration() == 0) {
      // din etapa 1
  /*    int periodicIgnite = Math.round((PConstants.IGNITE_OVERTIME
          + PConstants.IGNITE_OVERTIME_BONUS * this.getLevel())
          * landModifier(getCurrentTerrain()) * igniteModifier); */
      int periodicIgniteWithoutModifiers = Math.round((PConstants.IGNITE_OVERTIME
          + PConstants.IGNITE_OVERTIME_BONUS * this.getLevel())
          * landModifier(getCurrentTerrain()));
      int periodicIgnite = Math.round(periodicIgniteWithoutModifiers
          * (igniteModifier + getStrategyDamageModifier() + getAngelDamageModifier()));

      enemy.setOvertimeDamage(periodicIgnite);
      enemy.setOvertimeDuration(PConstants.OVERTIME_DURATION);

    }
    return ignite;
  }

  @Override
  public void getBuff(Angel angel) {
    angel.buff(this);
  }






}
