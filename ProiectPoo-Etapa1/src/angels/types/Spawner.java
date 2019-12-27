package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Spawner extends Angel {

  public Spawner(int xCoordinate, int yCoordinate, String type) {
    super(xCoordinate, yCoordinate, type);
  }
  GreatMagician greatMagician = new GreatMagician();
  @Override
  public void buff(Pyromancer pyromancer) {
    if(pyromancer.getHP() <= 0) {
      pyromancer.setHP(AngelsConstants.spawnerBuffP);
      this.notifyUpdate(greatMagician, "Spawner helped Pyromancer " + pyromancer.getIndex());
      this.notifyUpdate(greatMagician, "Player Pyromancer " + pyromancer.getIndex()
      + " was brought to life by an angel");
    }
  }

  @Override
  public void buff(Knight knight) {
    if(knight.getHP() <= 0) {
      knight.setHP(AngelsConstants.spawnerBuffK);
      this.notifyUpdate(greatMagician, "Spawner helped Knight " + knight.getIndex());
      this.notifyUpdate(greatMagician, "Player Knight " + knight.getIndex()
      + " was brought to life by an angel");
    }
  }

  @Override
  public void buff(Wizard wizard) {
    if(wizard.getHP() <= 0) {
      wizard.setHP(AngelsConstants.spawnerBuffW);
      this.notifyUpdate(greatMagician, "Spawner helped Wizard " + wizard.getIndex());
      this.notifyUpdate(greatMagician, "Player Wizard " + wizard.getIndex()
      + " was brought to life by an angel");
    }
  }

  @Override
  public void buff(Rogue rogue) {
    if(rogue.getHP() <= 0) {
      rogue.setHP(AngelsConstants.spawnerBuffR);
      this.notifyUpdate(greatMagician, "Spawner helped Rogue " + rogue.getIndex());
      this.notifyUpdate(greatMagician, "Player Rogue " + rogue.getIndex()
      + " was brought to life by an angel");
    }
  }



}
