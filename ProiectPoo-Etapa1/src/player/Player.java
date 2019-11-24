package player;

public abstract class Player {
  private String type;
  private int HP;
  private int XP;
  private int level;
  private int xCoordinate;
  private int yCoordinate;
  private int overtimeDamage;
  private int overtimeDuration;
  private char currentTerrain;
  private boolean isParalysed;
  private int damageGiven;
  private int damageTaken;


  public Player(String type, int hP, int xP, int xCoordinate, int yCoordinate, char currentTerrain) {
    super();
    this.type = type;
    this.HP = hP;
    this.XP = xP;
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


  public int getDamageGiven() {
    return damageGiven;
  }


  public void setDamageGiven(int damageGiven) {
    this.damageGiven = damageGiven;
  }


  public int getDamageTaken() {
    return damageTaken;
  }


  public void setDamageTaken(int damageTaken) {
    this.damageTaken = damageTaken;
  }


  public boolean isParalysed() {
    return isParalysed;
  }


  public void setParalysed(boolean isParalysed) {
    this.isParalysed = isParalysed;
  }


  public char getCurrentTerrain() {
    return currentTerrain;
  }


  public void setCurrentTerrain(char currentTerrain) {
    this.currentTerrain = currentTerrain;
  }


  public int getOvertimeDamage() {
    return overtimeDamage;
  }


  public void setOvertimeDamage(int overtimeDamage) {
    this.overtimeDamage = overtimeDamage;
  }


  public int getOvertimeDuration() {
    return overtimeDuration;
  }


  public void setOvertimeDuration(int overtimeDuration) {
    this.overtimeDuration = overtimeDuration;
  }


  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getHP() {
    return HP;
  }

  public void setHP(int hP) {
    HP = hP;
  }

  public int getXP() {
    return XP;
  }

  public void setXP(int xP) {
    XP = xP;
  }

  public int getxCoordinate() {
    return xCoordinate;
  }

  public void setxCoordinate(int xCoordinate) {
    this.xCoordinate = xCoordinate;
  }

  public int getyCoordinate() {
    return yCoordinate;
  }

  public void setyCoordinate(int yCoordinate) {
    this.yCoordinate = yCoordinate;
  }

  public abstract void fightsWith(Player player);
  public abstract void fight(Pyromancer pyromancer);
  public abstract void fight(Knight knight);
  public abstract void fight(Wizard wizard);
  public abstract void fight(Rogue rogue);


}
