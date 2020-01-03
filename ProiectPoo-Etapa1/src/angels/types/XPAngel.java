package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import gamemechanism.LevelUpCalculator;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class XPAngel extends Angel {

  public XPAngel(final int xCoordinate, final int yCoordinate, final String type) {
    super(xCoordinate, yCoordinate, type);
  }
  private LevelUpCalculator levelUpCalc = new LevelUpCalculator();
  private GreatMagician greatMagician = new GreatMagician();

  @Override
  public final void buff(final Pyromancer pyromancer) {
    if (pyromancer.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "XPAngel helped Pyromancer " + pyromancer.getIndex());
    pyromancer.setXP(pyromancer.getXP() + AngelsConstants.XP_ANGEL_BUFF_P);
    levelUpCalc.computeLevelUp(pyromancer);
  }

  @Override
  public final void buff(final Knight knight) {
    if (knight.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "XPAngel helped Knight " + knight.getIndex());
    knight.setXP(knight.getXP() + AngelsConstants.XP_ANGEL_BUFF_K);
    levelUpCalc.computeLevelUp(knight);
  }

  @Override
  public final void buff(final Wizard wizard) {
    if (wizard.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "XPAngel helped Wizard " + wizard.getIndex());
    wizard.setXP(wizard.getXP() + AngelsConstants.XP_ANGEL_BUFF_W);
    levelUpCalc.computeLevelUp(wizard);
  }

  @Override
  public final void buff(final Rogue rogue) {
    if (rogue.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "XPAngel helped Rogue " + rogue.getIndex());
    rogue.setXP(rogue.getXP() + AngelsConstants.XP_ANGEL_BUFF_R);
    levelUpCalc.computeLevelUp(rogue);
  }

}
