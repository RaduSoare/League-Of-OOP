package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class DarkAngel extends Angel {

  public DarkAngel(final int xCoordinate, final int yCoordinate, final String type) {
    super(xCoordinate, yCoordinate, type);

  }
  private GreatMagician greatMagician = new GreatMagician();
  @Override
  public final void buff(final Pyromancer pyromancer) {
    if (pyromancer.getHP() <= 0) {
      return;
    }
    pyromancer.setHP(pyromancer.getHP() - AngelsConstants.DARK_ANGEL_BUFF_P);
    this.notifyUpdate(greatMagician, "DarkAngel hit Pyromancer " + pyromancer.getIndex());
  }

  @Override
  public final void buff(final Knight knight) {
    if (knight.getHP() <= 0) {
      return;
    }
    knight.setHP(knight.getHP() - AngelsConstants.DARK_ANGEL_BUFF_K);
    this.notifyUpdate(greatMagician, "DarkAngel hit Knight " + knight.getIndex());

  }

  @Override
  public final void buff(final Wizard wizard) {
    if (wizard.getHP() <= 0) {
      return;
    }
    wizard.setHP(wizard.getHP() - AngelsConstants.DARK_ANGEL_BUFF_W);
    this.notifyUpdate(greatMagician, "DarkAngel hit Wizard " + wizard.getIndex());

  }

  @Override
  public final void buff(final Rogue rogue) {
    if (rogue.getHP() <= 0) {
      return;
    }
    rogue.setHP(rogue.getHP() - AngelsConstants.DARK_ANGEL_BUFF_R);
    this.notifyUpdate(greatMagician, "DarkAngel hit Rogue " + rogue.getIndex());

  }

}
