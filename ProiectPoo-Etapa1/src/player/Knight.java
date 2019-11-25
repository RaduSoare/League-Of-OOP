package player;

import common.KConstants;
import common.PConstants;
import common.RConstants;
import common.WConstants;

public class Knight extends Player  {

  public Knight(String type, int hP, int xP, int xCoordinate, int yCoordinate, char terrain) {
    super(type, hP, xP, xCoordinate, yCoordinate, terrain);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void fightsWith(Player player) {
    player.fight(this);
  }

  @Override
  public void fight(Pyromancer pyromancer) {
    int maxHp = PConstants.getPyroHp() + PConstants.getPyroBonusHp() * pyromancer.getLevel();
    int damage = getTotalDamage(pyromancer.getLevel(), maxHp, pyromancer.getHP(), KConstants.getExecutePModifier(),
        pyromancer, KConstants.getSlamPModifier());

    this.setDamageGiven(damage);
  }

  @Override
  public void fight(Knight knight) {

    int maxHp = KConstants.getKnightHp() + KConstants.getKnightBonusHp() * knight.getLevel();
    int damage = getTotalDamage(knight.getLevel(), maxHp, knight.getHP(), KConstants.getExecuteKModifier(),
        knight, KConstants.getSlamKModifier());
    this.setDamageGiven(damage);
  }

  @Override
  public void fight(Wizard wizard) {
    int maxHp = WConstants.getWizardHp() + WConstants.getWizardBonusHp() * wizard.getLevel();
    int damage = getTotalDamage(wizard.getLevel(), maxHp, wizard.getHP(), KConstants.getExecuteWModifier(),
        wizard, KConstants.getSlamWModifier());
    wizard.setDamageTaken(getExecuteWithoutModifiers(wizard.getLevel(), maxHp, wizard.getHP()) +
        getSlamWithoutModifiers(wizard));
    this.setDamageGiven(damage);

  }

  @Override
  public void fight(Rogue rogue) {
    int maxHp = RConstants.getRogueHp() + RConstants.getRogueBonusHp() * rogue.getLevel();
    int damage = getTotalDamage(rogue.getLevel(), maxHp, rogue.getHP(), KConstants.getExecuteRModifier(),
        rogue, KConstants.getSlamRModifier());
    this.setDamageGiven(damage);
  }

  public float landModifier(char terrainType) {
    if (terrainType == 'L') {
      return KConstants.getKnightLandModifier();
    }
    return 1f;
  }

  public int getExecuteWithoutModifiers(int enemylevel, int enemyMaxHp, int enemyHp ) {
    float hpLimitPercent = KConstants.getHpLimit() + KConstants.getHpLimitModifier() * enemylevel;
    if(hpLimitPercent > KConstants.getHpLimit()) {
      hpLimitPercent = KConstants.getHpLimit();
    }
    float hpLimit = hpLimitPercent * enemyMaxHp;
    if (enemyHp < hpLimit) {
      return enemyHp;
    } else {
      return Math.round((KConstants.getExecuteDamage() + KConstants.getExecuteDamageBonus()
      * this.getLevel()) * landModifier(getCurrentTerrain()));
    }
  }

  public int getExecute(int enemylevel, int enemyMaxHp, int enemyHp, float executeModifier) {
    //System.out.println(Math.round(getExecuteWithoutModifiers(enemylevel, enemyMaxHp, enemyHp) * executeModifier));
    return Math.round(getExecuteWithoutModifiers(enemylevel, enemyMaxHp, enemyHp) * executeModifier);
  }

  public int getSlamWithoutModifiers(Player enemy) {
    enemy.setParalysed(true);
    enemy.setOvertimeDuration(1);
    return Math.round((KConstants.getSlamDamage() + KConstants.getSlamDamageBonus() * this.getLevel()) *
        landModifier(getCurrentTerrain()));
  }

  public int getSlam(Player enemy, float slamModifier) {
   // System.out.println(Math.round(getSlamWithoutModifiers(enemy) * slamModifier));
    return Math.round(getSlamWithoutModifiers(enemy) * slamModifier);
  }

  public int getTotalDamage(int enemylevel, int enemyMaxHp, int enemyHp, float executeModifier,
      Player enemy, float slamModifier) {
    return getExecute(enemylevel, enemyMaxHp, enemyHp, executeModifier) + getSlam(enemy, slamModifier);
  }




}
