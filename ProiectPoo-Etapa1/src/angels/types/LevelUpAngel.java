package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import gamemechanism.LevelUpCalculator;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class LevelUpAngel extends Angel {

  public LevelUpAngel(int xCoordinate, int yCoordinate, String type) {
    super(xCoordinate, yCoordinate, type);
  }
  LevelUpCalculator levelUpCalc = new LevelUpCalculator();
  GreatMagician greatMagician = new GreatMagician();
  @Override
  public void buff(Pyromancer pyromancer) {
    if(pyromancer.getHP() <= 0) {
      return;
    }

    this.notifyUpdate(greatMagician, "LevelUpAngel helped Pyromancer " + pyromancer.getIndex() );
    pyromancer.setAngelDamageModifier(pyromancer.getAngelDamageModifier()
        + AngelsConstants.levelUpAngelBuffP);
    pyromancer.setXP(levelUpCalc.xpForNextLevel(pyromancer.getXP()));
    levelUpCalc.computeLevelUp(pyromancer);

  }

  @Override
  public void buff(Knight knight) {
    if(knight.getHP() <= 0) {
      return;
    }

    this.notifyUpdate(greatMagician, "LevelUpAngel helped Knight " + knight.getIndex());
    knight.setAngelDamageModifier(knight.getAngelDamageModifier()
        + AngelsConstants.levelUpAngelBuffK);
    knight.setXP(levelUpCalc.xpForNextLevel(knight.getXP()));
    levelUpCalc.computeLevelUp(knight);
  }

  @Override
  public void buff(Wizard wizard) {
    if(wizard.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "LevelUpAngel helped Wizard " + wizard.getIndex());
    wizard.setAngelDamageModifier(wizard.getAngelDamageModifier()
        + AngelsConstants.levelUpAngelBuffW);
    wizard.setXP(levelUpCalc.xpForNextLevel(wizard.getXP()));
    levelUpCalc.computeLevelUp(wizard);
  }

  @Override
  public void buff(Rogue rogue) {
    if(rogue.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "LevelUpAngel helped Rogue " + rogue.getIndex());
    rogue.setAngelDamageModifier(rogue.getAngelDamageModifier()
        + AngelsConstants.levelUpAngelBuffR);
    rogue.setXP(levelUpCalc.xpForNextLevel(rogue.getXP()));
    levelUpCalc.computeLevelUp(rogue);
  }

}
