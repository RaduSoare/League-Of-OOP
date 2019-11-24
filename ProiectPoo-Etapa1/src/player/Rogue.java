package player;

import common.RConstants;

public class Rogue extends Player {

  private int hits;
  private float critial;

  public Rogue(String type, int hP, int xP, int xCoordinate, int yCoordinate, char terrain) {
    super(type, hP, xP, xCoordinate, yCoordinate, terrain);
    this.hits = 0;
    this.critial = 1f;
    // TODO Auto-generated constructor stub
  }

  public float getCritial() {
    return critial;
  }

  public void setCritial(float critial) {
    this.critial = critial;
  }

  public int getHits() {
    return hits;
  }

  public void setHits(int hits) {
    this.hits = hits;
  }

  @Override
  public void fightsWith(Player player) {
    player.fight(this);
  }

  @Override
  public void fight(Pyromancer pyromancer) {

  }

  @Override
  public void fight(Knight knight) {

  }

  @Override
  public void fight(Wizard wizard) {

   this.applyParalysis(wizard);
   wizard.setOvertimeDamage(Math.round(wizard.getOvertimeDamage() * RConstants.getParalysisWModifier()));
   // setez damage-ul luat pentru a putea calcula deflect-ul
   wizard.setDamageTaken(getBackstabWithoutModifiers() + getParalysisWithoutModifiers());
   int damage = getTotalDamage(RConstants.getBackstabWModifier(), RConstants.getParalysisWModifier());
   this.setHits(getHits() + 1);

   this.setDamageGiven(damage);
  }

  @Override
  public void fight(Rogue rogue) {
    this.applyParalysis(rogue);
    rogue.setOvertimeDamage(Math.round(rogue.getOvertimeDamage() * RConstants.getParalysisRModifier()));
    // setez damage-ul luat pentru a putea calcula deflect-ul
    rogue.setDamageTaken(getBackstabWithoutModifiers() + getParalysisWithoutModifiers());

    int damage = getTotalDamage(RConstants.getBackstabRModifier(), RConstants.getParalysisRModifier());
    this.setHits(getHits() + 1);

    this.setDamageGiven(damage);
  }


  public int getBackstabWithoutModifiers() {
    return Math.round((RConstants.getBackstabDamage() +
        RConstants.getBackstabDamageBonus() * this.getLevel()) *
        criticalDamage(this.getCurrentTerrain()) * landModifier(getCurrentTerrain()));
  }

  public int getBackstab(float backstabModifier) {
    return Math.round(getBackstabWithoutModifiers() * backstabModifier);
  }

  public int getParalysisWithoutModifiers() {
    return Math.round((RConstants.getParalysisDamage() +
        RConstants.getBackstabDamageBonus() * this.getLevel()) *
        landModifier(getCurrentTerrain()));
  }

  public int getParalysis(float paralysisModifier) {
    return Math.round(getParalysisWithoutModifiers() * paralysisModifier);
  }
  public int getTotalWithoutModifiers() {
    return getBackstabWithoutModifiers() + getParalysisWithoutModifiers();
  }

  public int getTotalDamage(float backstabModifier, float paralysisModifier) {
    return getBackstab(backstabModifier) + getParalysis(paralysisModifier);

  }

  void applyParalysis(Player enemy) {
    if (this.getCurrentTerrain() == 'W') {
      enemy.setParalysed(true);
      enemy.setOvertimeDamage(RConstants.getParalysisDamage() + (RConstants.getParalysisDamageBonus() * this.getLevel()));
      enemy.setOvertimeDuration(RConstants.getParalysisOvertime() * 2);
    } else {
      enemy.setParalysed(true);
      enemy.setOvertimeDamage(RConstants.getParalysisDamage() + (RConstants.getParalysisDamageBonus() * this.getLevel()));
      enemy.setOvertimeDuration(RConstants.getParalysisOvertime());
    }
  }

  public float landModifier(char terrainType) {
    if (terrainType == 'W') {
      return RConstants.getRogueLandModifier();
    }
    return 1f;
  }

  public float criticalDamage(char terrainType) {
    if(terrainType != 'W' && (hits == 0 || hits % 3 == 0)){
      this.critial = RConstants.getCriticalBonus();
      return 1f;
    } else if( (terrainType == 'W' && this.critial == RConstants.getCriticalBonus()) ||
        (terrainType == 'W' && (hits == 0 || hits % 3 == 0)) ) {
      this.setCritial(1f);
      return RConstants.getCriticalBonus();
    }
    return 1f;
  }



}
