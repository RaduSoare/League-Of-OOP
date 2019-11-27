package player;

public abstract class Player {
  private String type;
  private int hp;
  private int xp;
  private int level;
  private int xCoordinate;
  private int yCoordinate;
  private int overtimeDamage;
  private int overtimeDuration;
  private char currentTerrain;
  private boolean isParalysed;
  private int damageGiven;
  private int damageTaken;


  public Player(final String type, final int hP, final int xP, final int xCoordinate,
      final int yCoordinate, final char currentTerrain) {
    super();
    this.type = type;
    this.hp = hP;
    this.xp = xP;
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.level = 0;
    this.overtimeDamage = 0;
    this.overtimeDuration = 0;
    this.currentTerrain = currentTerrain;
    this.isParalysed = false;
    this.damageGiven = 0;
    this.damageTaken = 0;
  }


  public final int getDamageGiven() {
    return damageGiven;
  }


  public final void setDamageGiven(final int damageGiven) {
    this.damageGiven = damageGiven;
  }


  public final int getDamageTaken() {
    return damageTaken;
  }


  public final void setDamageTaken(final int damageTaken) {
    this.damageTaken = damageTaken;
  }


  public final boolean isParalysed() {
    return isParalysed;
  }


  public final void setParalysed(final boolean checkIsParalysed) {
    this.isParalysed = checkIsParalysed;
  }


  public final char getCurrentTerrain() {
    return currentTerrain;
  }


  public final void setCurrentTerrain(final char currentTerrain) {
    this.currentTerrain = currentTerrain;
  }


  public final int getOvertimeDamage() {
    return overtimeDamage;
  }


  public final void setOvertimeDamage(final int overtimeDamage) {
    this.overtimeDamage = overtimeDamage;
  }


  public final int getOvertimeDuration() {
    return overtimeDuration;
  }


  public final void setOvertimeDuration(final int overtimeDuration) {
    this.overtimeDuration = overtimeDuration;
  }


  public final int getLevel() {
    return level;
  }

  public final void setLevel(final int level) {
    this.level = level;
  }
  public final String getType() {
    return type;
  }

  public final void setType(final String type) {
    this.type = type;
  }

  public final int getHP() {
    return hp;
  }

  public final void setHP(final int hP) {
    hp = hP;
  }

  public final int getXP() {
    return xp;
  }

  public final void setXP(final int xP) {
    xp = xP;
  }

  public final int getxCoordinate() {
    return xCoordinate;
  }

  public final void setxCoordinate(final int xCoordinate) {
    this.xCoordinate = xCoordinate;
  }

  public final int getyCoordinate() {
    return yCoordinate;
  }

  public final void setyCoordinate(final int yCoordinate) {
    this.yCoordinate = yCoordinate;
  }

  public abstract void fightsWith(Player player);
  public abstract void fight(Pyromancer pyromancer);
  public abstract void fight(Knight knight);
  public abstract void fight(Wizard wizard);
  public abstract void fight(Rogue rogue);


}
