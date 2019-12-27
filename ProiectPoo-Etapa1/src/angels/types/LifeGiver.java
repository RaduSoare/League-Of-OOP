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
  MaxHpCalculator maxHp = new MaxHpCalculator();
  GreatMagician greatMagician = new GreatMagician();
  public LifeGiver(int xCoordinate, int yCoordinate, String type) {
    super(xCoordinate, yCoordinate, type);
  }

  @Override
  public void buff(Pyromancer pyromancer) {
    if(pyromancer.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "LifeGiver helped Pyromancer " + pyromancer.getIndex());
    pyromancer.setHP(pyromancer.getHP() + AngelsConstants.lifeGiverBuffP);
    if(pyromancer.getHP() > maxHp.computeMaxHpP(pyromancer)) {
      pyromancer.setHP(maxHp.computeMaxHpP(pyromancer));
    }
  }

  @Override
  public void buff(Knight knight) {
    if(knight.getHP() <= 0) {
      return;
    }

    this.notifyUpdate(greatMagician, "LifeGiver helped Knight " + knight.getIndex());
    knight.setHP(knight.getHP() + AngelsConstants.lifeGiverBuffK);
    if(knight.getHP() > maxHp.computeMaxHpK(knight)) {
      knight.setHP(maxHp.computeMaxHpK(knight));
    }
  }

  @Override
  public void buff(Wizard wizard) {

    if(wizard.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "LifeGiver helped Wizard " + wizard.getIndex());
    wizard.setHP(wizard.getHP() + AngelsConstants.lifeGiverBuffW);
    if(wizard.getHP() > maxHp.computeMaxHpW(wizard)) {
      wizard.setHP(maxHp.computeMaxHpW(wizard));
    }
  }

  @Override
  public void buff(Rogue rogue) {
    if(rogue.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "LifeGiver helped Rogue " + rogue.getIndex());
    rogue.setHP(rogue.getHP() + AngelsConstants.lifeGiverBuffR);
    if(rogue.getHP() > maxHp.computeMaxHpR(rogue)) {
      rogue.setHP(maxHp.computeMaxHpR(rogue));
    }
  }

}
