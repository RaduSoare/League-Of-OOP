package player;

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
    // TODO Auto-generated method stub
    //System.out.println("P-P");


  }

  @Override
  public void fight(Knight knight) {
    // TODO Auto-generated method stub
    System.out.println("P-K");
  }

  @Override
  public void fight(Wizard wizard) {
    // TODO Auto-generated method stub
    System.out.println("P-W");
  }

  @Override
  public void fight(Rogue rogue) {
    // TODO Auto-generated method stub
    System.out.println("P-R");
  }






}
