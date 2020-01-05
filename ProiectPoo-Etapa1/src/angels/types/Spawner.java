package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Spawner extends Angel {

  private GreatMagician greatMagician = new GreatMagician();
  public Spawner(final int xCoordinate, final int yCoordinate, final String type) {
    super(xCoordinate, yCoordinate, type);
    this.attach(greatMagician);
  }

  @Override
  public final void buff(final Pyromancer pyromancer) {
    if (pyromancer.getHP() <= 0) {
      pyromancer.setHP(AngelsConstants.SPAWNER_BUFF_P);
      this.notifyUpdate(greatMagician, "Spawner helped Pyromancer " + pyromancer.getIndex());
      this.notifyUpdate(greatMagician, "Player Pyromancer " + pyromancer.getIndex()
      + " was brought to life by an angel");
    }
  }

  @Override
  public final void buff(final Knight knight) {
    if (knight.getHP() <= 0) {
      knight.setHP(AngelsConstants.SPAWNER_BUFF_K);
      this.notifyUpdate(greatMagician, "Spawner helped Knight " + knight.getIndex());
      this.notifyUpdate(greatMagician, "Player Knight " + knight.getIndex()
      + " was brought to life by an angel");
    }
  }

  @Override
  public final void buff(final Wizard wizard) {
    if (wizard.getHP() <= 0) {
      wizard.setHP(AngelsConstants.SPAWNER_BUFF_W);
      this.notifyUpdate(greatMagician, "Spawner helped Wizard " + wizard.getIndex());
      this.notifyUpdate(greatMagician, "Player Wizard " + wizard.getIndex()
      + " was brought to life by an angel");
    }
  }

  @Override
  public final void buff(final Rogue rogue) {
    if (rogue.getHP() <= 0) {
      rogue.setHP(AngelsConstants.SPAWNER_BUFF_R);
      this.notifyUpdate(greatMagician, "Spawner helped Rogue " + rogue.getIndex());
      this.notifyUpdate(greatMagician, "Player Rogue " + rogue.getIndex()
      + " was brought to life by an angel");
    }
  }



}
