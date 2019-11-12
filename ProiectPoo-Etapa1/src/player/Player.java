package player;

public class Player {
  private String type;
  private int HP;
  private int XP;
  private int xCoordinate;
  private int yCoordinate;

  public Player(String type, int hP, int xP, int xCoordinate, int yCoordinate) {
    super();
    this.type = type;
    HP = hP;
    XP = xP;
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
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

}
