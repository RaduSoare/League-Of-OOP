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

  public XPAngel(int xCoordinate, int yCoordinate, String type) {
    super(xCoordinate, yCoordinate, type);
  }
  LevelUpCalculator levelUpCalc = new LevelUpCalculator();
  GreatMagician greatMagician = new GreatMagician();
  @Override
  public void buff(Pyromancer pyromancer) {
    if(pyromancer.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "XPAngel helped Pyromancer " + pyromancer.getIndex() );
    pyromancer.setXP(pyromancer.getXP() + AngelsConstants.xpAngelBuffP);
    levelUpCalc.computeLevelUp(pyromancer);
  }

  @Override
  public void buff(Knight knight) {
    if(knight.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "XPAngel helped Knight " + knight.getIndex());
    knight.setXP(knight.getXP() + AngelsConstants.xpAngelBuffK);
    levelUpCalc.computeLevelUp(knight);
  }

  @Override
  public void buff(Wizard wizard) {
    if(wizard.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "XPAngel helped Wizard " + wizard.getIndex());
    wizard.setXP(wizard.getXP() + AngelsConstants.xpAngelBuffW);
    levelUpCalc.computeLevelUp(wizard);
  }

  @Override
  public void buff(Rogue rogue) {
    if(rogue.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "XPAngel helped Rogue " + rogue.getIndex());
    rogue.setXP(rogue.getXP() + AngelsConstants.xpAngelBuffR);
    levelUpCalc.computeLevelUp(rogue);
  }

}
