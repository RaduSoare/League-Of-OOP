package player;

import common.KConstants;
import common.PConstants;
import common.RConstants;
import common.WConstants;

public class Wizard extends Player {
  private int damageTaken;
  public Wizard(String type, int hP, int xP, int xCoordinate, int yCoordinate, char terrain) {
    super(type, hP, xP, xCoordinate, yCoordinate, terrain);
    // TODO Auto-generated constructor stub
    this.damageTaken = 0;
  }

  @Override
  public int getDamageTaken() {
    return damageTaken;
  }

  @Override
  public void setDamageTaken(int damageTaken) {
    this.damageTaken = damageTaken;
  }

  @Override
  public void fightsWith(Player player) {
    player.fight(this);
  }

  @Override
  public void fight(Pyromancer pyromancer) {
    int enemyMaxHp = PConstants.getPyroHp() + PConstants.getPyroBonusHp() * pyromancer.getLevel();
    int drain = drainDamage(enemyMaxHp,  pyromancer.getHP(), WConstants.getDrainRModifier());
    int deflect = deflectDamage(WConstants.getDeflectRModifier());
    int damage = drain + deflect;
    this.setDamageGiven(damage);
  }

  @Override
  public void fight(Knight knight) {
    int enemyMaxHp = KConstants.getKnightHp() + KConstants.getKnightBonusHp() * knight.getLevel();
    int drain = drainDamage(enemyMaxHp,  knight.getHP(), WConstants.getDrainRModifier());
    int deflect = deflectDamage(WConstants.getDeflectRModifier());
    int damage = drain + deflect;
    this.setDamageGiven(damage);
  }

  @Override
  public void fight(Wizard wizard) {
    int enemyMaxHp = WConstants.getWizardHp() + WConstants.getWizardBonusHp() * wizard.getLevel();
    int drain = drainDamage(enemyMaxHp, wizard.getHP(), WConstants.getDrainWModifier());
    //int deflect = deflectDamage(WConstants.getDeflectWModifier());
    int deflect = 0;
    int damage = drain + deflect;
    this.setDamageGiven(damage);
  }

  @Override
  public void fight(Rogue rogue) {
    int enemyMaxHp = RConstants.getRogueHp() + RConstants.getRogueBonusHp() * rogue.getLevel();
    int drain = drainDamage(enemyMaxHp,  rogue.getHP(), WConstants.getDrainRModifier());
    int deflect = deflectDamage(WConstants.getDeflectRModifier());
    int damage = drain + deflect;
    this.setDamageGiven(damage);

  }

  public float landModifier(char terrainType) {
    if (terrainType == 'D') {
      return WConstants.getWizardLandModifier();
    }
    return 1f;
  }

  public int drainDamage(int enemyMaxHp, int enemyHp, float drainModifier) {
    int baseHp = (int) Math.min(0.3f * enemyMaxHp , enemyHp);
    float percent = WConstants.getDrainPercent() + WConstants.getDrainPercentBonus() * this.getLevel();
    percent = percent * drainModifier * landModifier(getCurrentTerrain());
    int drain = Math.round(percent * baseHp);

    return drain;
  }

  public int deflectDamage(float deflectModifier) {
    int deflect = Math.round(this.damageTaken * (WConstants.getDeflectPercent() +
        WConstants.getDeflectPercentBonus() * this.getLevel()));
    deflect = Math.round(deflect * deflectModifier * landModifier(getCurrentTerrain()));

    return deflect;
  }

}
