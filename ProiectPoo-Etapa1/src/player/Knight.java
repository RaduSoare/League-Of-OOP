package player;

public class Knight extends Player  {

  public Knight(String type, int hP, int xP, int xCoordinate, int yCoordinate, char terrain) {
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
    // TODO Auto-generated method stub
    System.out.println("K-P");
  }

  @Override
  public void fight(Knight knight) {
    // TODO Auto-generated method stub
    System.out.println("K-K");
  }

  @Override
  public void fight(Wizard wizard) {
    // TODO Auto-generated method stub
    System.out.println("K-W");
  }

  @Override
  public void fight(Rogue rogue) {
    // TODO Auto-generated method stub
    System.out.println("K-R");
  }

}
