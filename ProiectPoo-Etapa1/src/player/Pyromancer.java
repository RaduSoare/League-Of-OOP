package player;

import common.PConstants;

public class Pyromancer extends Player  {



  public Pyromancer(String type, int hP, int xP, int xCoordinate, int yCoordinate, char terrain) {
    super(type, hP, xP, xCoordinate, yCoordinate, terrain);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void fightsWith(Player player) {
    // TODO Auto-generated method stub
    player.fight(this);
  }

  @Override
  public void fight(Pyromancer pyromancer) {
    int damage = getFireblast(PConstants.getFireblastPModifier()) +
        getIgnite(pyromancer, PConstants.getIgnitePModifier());
    this.setDamageGiven(damage);


  }

  @Override
  public void fight(Knight knight) {
    int damage = getFireblast(PConstants.getFireblastKModifier()) +
        getIgnite(knight, PConstants.getIgniteKModifier());
    this.setDamageGiven(damage);

  }

  @Override
  public void fight(Wizard wizard) {
    // TODO Auto-generated method stub
    int damage = getFireblast(PConstants.getFireblastWModifier()) +
        getIgnite(wizard, PConstants.getIgniteWModifier());
    wizard.setDamageTaken(Math.round(getFireblastWithoutModifiers() + getIgniteWithoutModifiers() ));
    this.setDamageGiven(damage);
  }

  @Override
  public void fight(Rogue rogue) {
    int damage = getFireblast(PConstants.getFireblastRModifier()) +
        getIgnite(rogue, PConstants.getIgniteRModifier());
    this.setDamageGiven(damage);
  }

  public float landModifier(char terrainType) {
    if (terrainType == 'V') {
      return PConstants.getPyroLandModifier();
    }
    return 1f;
  }

  public float getFireblastWithoutModifiers() {
    return (PConstants.getFireblastDamage() + PConstants.getFireblastDamageBonus() *
        this.getLevel() ) * landModifier(getCurrentTerrain());
  }

  public int getFireblast(float fireblastModifier) {
   // System.out.println(Math.round(getFireblastWithoutModifiers() * fireblastModifier));
    return Math.round(getFireblastWithoutModifiers() * fireblastModifier);
  }

  public float getIgniteWithoutModifiers() {
    return (PConstants.getIgniteDamage() + PConstants.getIgniteDamageBonus() *
        this.getLevel()) * landModifier(getCurrentTerrain());
  }

  public int getIgnite(Player enemy,float igniteModifier) {
    //System.out.println(Math.round(getIgniteWithoutModifiers() * igniteModifier));
    int ignite =  Math.round(getIgniteWithoutModifiers() * igniteModifier);
    if(enemy.getOvertimeDuration() == 0) {
      int periodicIgnite = Math.round((PConstants.getIgniteOvertime() +
          PConstants.getIgniteOvertimeBonus() * this.getLevel()) *
          landModifier(getCurrentTerrain()) * igniteModifier);
      enemy.setOvertimeDamage(periodicIgnite);
      enemy.setOvertimeDuration(PConstants.getOvertimeDuration());
    }
    return ignite;
  }






}
