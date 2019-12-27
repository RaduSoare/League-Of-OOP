package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class SmallAngel extends Angel {

  public SmallAngel(int xCoordinate, int yCoordinate, String type) {
    super(xCoordinate, yCoordinate, type);
  }
  GreatMagician greatMagician = new GreatMagician();
  @Override
  public void buff(Pyromancer pyromancer) {
    if(pyromancer.getHP() <= 0) {
      return;
    }
    pyromancer.setAngelDamageModifier(pyromancer.getAngelDamageModifier()
        + AngelsConstants.smallAngelBuffDmgP);
    pyromancer.setHP(pyromancer.getHP() + AngelsConstants.smallAngelBuffHpP);
    this.notifyUpdate(greatMagician, "SmallAngel helped Pyromancer " + pyromancer.getIndex());
  }

  @Override
  public void buff(Knight knight) {
    if(knight.getHP() <= 0) {
      return;
    }
    knight.setAngelDamageModifier(knight.getAngelDamageModifier()
        + AngelsConstants.smallAngelBuffDmgK);
    knight.setHP(knight.getHP() + AngelsConstants.smallAngelBuffHpK);
    this.notifyUpdate(greatMagician, "SmallAngel helped Knight " + knight.getIndex());
  }

  @Override
  public void buff(Wizard wizard) {
    if(wizard.getHP() <= 0) {
      return;
    }
    wizard.setAngelDamageModifier(wizard.getAngelDamageModifier()
        + AngelsConstants.smallAngelBuffDmgW);
    wizard.setHP(wizard.getHP() + AngelsConstants.smallAngelBuffHpW);
    this.notifyUpdate(greatMagician, "SmallAngel helped Wizard " + wizard.getIndex());

  }

  @Override
  public void buff(Rogue rogue) {
    if(rogue.getHP() <= 0) {
      return;
    }
    rogue.setAngelDamageModifier(rogue.getAngelDamageModifier()
        + AngelsConstants.smallAngelBuffDmgR);
    rogue.setHP(rogue.getHP() + AngelsConstants.smallAngelBuffHpR);
    this.notifyUpdate(greatMagician, "SmallAngel helped Rogue " + rogue.getIndex());

  }

}
