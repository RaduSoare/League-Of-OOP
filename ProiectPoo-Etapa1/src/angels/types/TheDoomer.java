package angels.types;

import angels.Angel;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class TheDoomer extends Angel {

  public TheDoomer(int xCoordinate, int yCoordinate, String type) {
    super(xCoordinate, yCoordinate, type);
  }
  GreatMagician greatMagician = new GreatMagician();
  @Override
  public void buff(Pyromancer pyromancer) {
    if(pyromancer.getHP() > 0) {
      pyromancer.setHP(0);
      this.notifyUpdate(greatMagician, "TheDoomer hit Pyromancer " + pyromancer.getIndex());
      this.notifyUpdate(greatMagician, "Player Pyromancer " + pyromancer.getIndex()
      + " was killed by an angel");
    }
  }

  @Override
  public void buff(Knight knight) {

    if(knight.getHP() > 0) {
      knight.setHP(0);
      this.notifyUpdate(greatMagician, "TheDoomer hit Knight " + knight.getIndex() );
      this.notifyUpdate(greatMagician, "Player Knight " + knight.getIndex()
      + " was killed by an angel");
    }
  }

  @Override
  public void buff(Wizard wizard) {
    if(wizard.getHP() > 0) {
      wizard.setHP(0);
      this.notifyUpdate(greatMagician, "TheDoomer hit Wizard " + wizard.getIndex() );
      this.notifyUpdate(greatMagician, "Player Wizard " + wizard.getIndex()
      + " was killed by an angel");
    }

  }

  @Override
  public void buff(Rogue rogue) {
   if(rogue.getHP() > 0) {
     rogue.setHP(0);
     this.notifyUpdate(greatMagician, "TheDoomer hit Rogue " + rogue.getIndex() );
     this.notifyUpdate(greatMagician, "Player Rogue " + rogue.getIndex()
     + " was killed by an angel");
   }
  }

}
