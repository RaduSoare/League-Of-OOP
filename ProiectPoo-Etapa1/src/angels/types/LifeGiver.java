package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import gamemechanism.MaxHpCalculator;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class LifeGiver extends Angel {
  private MaxHpCalculator maxHp = new MaxHpCalculator();
  private GreatMagician greatMagician = new GreatMagician();

  public LifeGiver(final int xCoordinate, final int yCoordinate, final String type) {
    super(xCoordinate, yCoordinate, type);
    this.attach(greatMagician);
  }

  @Override
  public final void buff(final Pyromancer pyromancer) {
    if (pyromancer.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "LifeGiver helped Pyromancer " + pyromancer.getIndex());
    pyromancer.setHP(pyromancer.getHP() + AngelsConstants.LIFE_GIVER_BUFF_P);
    if (pyromancer.getHP() > maxHp.computeMaxHpP(pyromancer)) {
      pyromancer.setHP(maxHp.computeMaxHpP(pyromancer));
    }
  }

  @Override
  public final void buff(final Knight knight) {
    if (knight.getHP() <= 0) {
      return;
    }

    this.notifyUpdate(greatMagician, "LifeGiver helped Knight " + knight.getIndex());
    knight.setHP(knight.getHP() + AngelsConstants.LIFE_GIVER_BUFF_K);
    if (knight.getHP() > maxHp.computeMaxHpK(knight)) {
      knight.setHP(maxHp.computeMaxHpK(knight));
    }
  }

  @Override
  public final void buff(final Wizard wizard) {

    if (wizard.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "LifeGiver helped Wizard " + wizard.getIndex());
    wizard.setHP(wizard.getHP() + AngelsConstants.LIFE_GIVER_BUFF_W);
    if (wizard.getHP() > maxHp.computeMaxHpW(wizard)) {
      wizard.setHP(maxHp.computeMaxHpW(wizard));
    }
  }

  @Override
  public final void buff(final Rogue rogue) {
    if (rogue.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "LifeGiver helped Rogue " + rogue.getIndex());
    rogue.setHP(rogue.getHP() + AngelsConstants.LIFE_GIVER_BUFF_R);
    if (rogue.getHP() > maxHp.computeMaxHpR(rogue)) {
      rogue.setHP(maxHp.computeMaxHpR(rogue));
    }
  }

}
