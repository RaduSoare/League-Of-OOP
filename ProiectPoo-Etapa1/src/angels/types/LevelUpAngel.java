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

  private LevelUpCalculator levelUpCalc = new LevelUpCalculator();
  private GreatMagician greatMagician = new GreatMagician();
  public LevelUpAngel(final int xCoordinate, final int yCoordinate, final String type) {
    super(xCoordinate, yCoordinate, type);
    this.attach(greatMagician);
  }

  @Override
  public final void buff(final Pyromancer pyromancer) {
    if (pyromancer.getHP() <= 0) {
      return;
    }

    this.notifyUpdate(greatMagician, "LevelUpAngel helped Pyromancer " + pyromancer.getIndex());
    pyromancer.setAngelDamageModifier(pyromancer.getAngelDamageModifier()
        + AngelsConstants.LEVEL_UP_ANGEL_BUFF_P);
    pyromancer.setXP(levelUpCalc.xpForNextLevel(pyromancer.getXP()));
    levelUpCalc.computeLevelUp(pyromancer);


  }

  @Override
  public final void buff(final Knight knight) {
    if (knight.getHP() <= 0) {
      return;
    }

    this.notifyUpdate(greatMagician, "LevelUpAngel helped Knight " + knight.getIndex());
    knight.setAngelDamageModifier(knight.getAngelDamageModifier()
        + AngelsConstants.LEVEL_UP_ANGEL_BUFF_K);
    knight.setXP(levelUpCalc.xpForNextLevel(knight.getXP()));
    levelUpCalc.computeLevelUp(knight);
  }

  @Override
  public final void buff(final Wizard wizard) {
    if (wizard.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "LevelUpAngel helped Wizard " + wizard.getIndex());
    wizard.setAngelDamageModifier(wizard.getAngelDamageModifier()
        + AngelsConstants.LEVEL_UP_ANGEL_BUFF_W);
    wizard.setXP(levelUpCalc.xpForNextLevel(wizard.getXP()));
    levelUpCalc.computeLevelUp(wizard);
  }

  @Override
  public final void buff(final Rogue rogue) {
    if (rogue.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "LevelUpAngel helped Rogue " + rogue.getIndex());
    rogue.setAngelDamageModifier(rogue.getAngelDamageModifier()
        + AngelsConstants.LEVEL_UP_ANGEL_BUFF_R);
    rogue.setXP(levelUpCalc.xpForNextLevel(rogue.getXP()));
    levelUpCalc.computeLevelUp(rogue);
  }

}
