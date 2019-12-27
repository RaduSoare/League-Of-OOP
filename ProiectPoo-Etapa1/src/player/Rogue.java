package player;

import angels.Angel;
import common.player.Constants;
import common.player.RConstants;

public class Rogue extends Player {

  private int hits;
  private float critial;

  public Rogue(final String type, final int hP, final int xP, final int xCoordinate,
      final int yCoordinate, final char terrain, final int index) {
    super(type, hP, xP, xCoordinate, yCoordinate, terrain, index);
    this.hits = 0;
    this.critial = 1f;
  }

  public final float getCritial() {
    return critial;
  }

  public final void setCritial(final float critial) {
    this.critial = critial;
  }

  public final int getHits() {
    return hits;
  }

  public final void setHits(final int hits) {
    this.hits = hits;
  }

  @Override
  public final void fightsWith(final Player player) {
    player.fight(this);
  }

  @Override
  public final void fight(final Pyromancer pyromancer) {

    this.applyParalysis(pyromancer,  RConstants.PARALYSIS_P_MODIFIER);
    int damage = getTotalDamage(RConstants.BACKSTAB_P_MODIFIER, RConstants.PARALYSIS_P_MODIFIER);
    this.setHits(getHits() + 1);
    this.setDamageGiven(damage);
  }

  @Override
  public final void fight(final Knight knight) {

    this.applyParalysis(knight, RConstants.PARALYSIS_K_MODIFIER);
    int damage = getTotalDamage(RConstants.BACKSTAB_K_MODIFIER, RConstants.PARALYSIS_K_MODIFIER);
    this.setHits(getHits() + 1);
    this.setDamageGiven(damage);
  }

  @Override
  public final void fight(final Wizard wizard) {

   this.applyParalysis(wizard, RConstants.PARALYSIS_W_MODIFIER);

   // se seteaza damage-ul primit de wizard pentru a se putea calcula damage-ul dat de deflect
   wizard.setDamageTaken(Math.round(getBackstabWithoutModifiers()
       + getParalysisWithoutModifiers()));
   int damage = getTotalDamage(RConstants.BACKSTAB_W_MODIFIER, RConstants.PARALYSIS_W_MODIFIER);
   this.setHits(getHits() + 1);
   this.setDamageGiven(damage);
  }

  @Override
  public final void fight(final Rogue rogue) {

    this.applyParalysis(rogue, RConstants.PARALYSIS_R_MODIFIER);
    int damage = getTotalDamage(RConstants.BACKSTAB_R_MODIFIER, RConstants.PARALYSIS_R_MODIFIER);
    this.setHits(getHits() + 1);
    this.setDamageGiven(damage);
  }


  public final float getBackstabWithoutModifiers() {

    return (RConstants.BACKSTAB_DAMAGE + RConstants.BACKSTAB_DAMAGE_BONUS * this.getLevel())
        * criticalDamage(this.getCurrentTerrain()) * landModifier(getCurrentTerrain());
  }

  public final int getBackstab(final float backstabModifier) {

    return Math.round(getBackstabWithoutModifiers()
        * (backstabModifier + getStrategyDamageModifier() + getAngelDamageModifier()));
  }

  public final float getParalysisWithoutModifiers() {

    return (RConstants.PARALYSIS_DAMAGE + RConstants.PARALYSIS_DAMAGE_BONUS * this.getLevel())
        * landModifier(getCurrentTerrain());
  }

  public final int getParalysis(final float paralysisModifier) {

    return Math.round(getParalysisWithoutModifiers()
        * (paralysisModifier + getStrategyDamageModifier() + getAngelDamageModifier()));
  }

  public final float getTotalWithoutModifiers() {

    return getBackstabWithoutModifiers() + getParalysisWithoutModifiers();
  }

  public final int getTotalDamage(final float backstabModifier, final float paralysisModifier) {

    return getBackstab(backstabModifier) + getParalysis(paralysisModifier);

  }

  public final void applyParalysis(final Player enemy, final float paralysisModifier) {

    if (this.getCurrentTerrain() == 'W') {
       enemy.setParalysed(true);
       enemy.setOvertimeDamage(Math.round((RConstants.PARALYSIS_DAMAGE
           + (RConstants.PARALYSIS_DAMAGE_BONUS * this.getLevel())) * (paralysisModifier + getStrategyDamageModifier())
           * landModifier(getCurrentTerrain())));
       enemy.setOvertimeDuration(RConstants.PARALYSIS_OVERTIME * 2);

    } else {
      enemy.setParalysed(true);
      enemy.setOvertimeDamage(Math.round((RConstants.PARALYSIS_DAMAGE
          + (RConstants.PARALYSIS_DAMAGE_BONUS * this.getLevel()))
          * (paralysisModifier + getStrategyDamageModifier()) * landModifier(getCurrentTerrain())));
      enemy.setOvertimeDuration(RConstants.PARALYSIS_OVERTIME);
    }
  }

  public final float landModifier(final char terrainType) {

    if (terrainType == 'W') {
      return RConstants.ROGUE_LAND_MODIFIER;
    }
    return 1f;
  }

  public final float criticalDamage(final char terrainType) {

    if (terrainType != 'W' && (hits == 0 || hits % Constants.CRITICAL_INTERVAL == 0)) {
      this.critial = RConstants.CRITICAL_BONUS;
      return 1f;
    } else if ((terrainType == 'W' && this.critial == RConstants.CRITICAL_BONUS)
        || (terrainType == 'W' && (hits == 0 || hits % Constants.CRITICAL_INTERVAL == 0))) {
      this.setCritial(1f);
      return RConstants.CRITICAL_BONUS;
    }
    return 1f;
  }

  @Override
  public void getBuff(Angel angel) {
    // TODO Auto-generated method stub
    angel.buff(this);
  }



}
