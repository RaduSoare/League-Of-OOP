package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class GoodBoy extends Angel {

  public GoodBoy(int xCoordinate, int yCoordinate, String type) {
    super(xCoordinate, yCoordinate, type);

  }
  GreatMagician greatMagician = new GreatMagician();
  @Override
  public void buff(Pyromancer pyromancer) {
    if(pyromancer.getHP() <= 0) {
      return;
    }
    pyromancer.setAngelDamageModifier(pyromancer.getAngelDamageModifier()
        + AngelsConstants.goodBoyBuffDmgP);
    pyromancer.setHP(pyromancer.getHP() + AngelsConstants.goodBoyBuffHpP);
    this.notifyUpdate(greatMagician, "GoodBoy helped Pyromancer " + pyromancer.getIndex() );

  }

  @Override
  public void buff(Knight knight) {
    if(knight.getHP() <= 0) {
      return;
    }
    knight.setAngelDamageModifier(knight.getAngelDamageModifier()
        + AngelsConstants.goodBoyBuffDmgK);
    knight.setHP(knight.getHP() + AngelsConstants.goodBoyBuffHpK);
    this.notifyUpdate(greatMagician, "GoodBoy helped Knight " + knight.getIndex() );

  }

  @Override
  public void buff(Wizard wizard) {
    if(wizard.getHP() <= 0) {
      return;
    }
    wizard.setAngelDamageModifier(wizard.getAngelDamageModifier()
        + AngelsConstants.goodBoyBuffDmgW);
    wizard.setHP(wizard.getHP() + AngelsConstants.goodBoyBuffHpW);
    this.notifyUpdate(greatMagician, "GoodBoy helped Wizard " + wizard.getIndex() );

  }

  @Override
  public void buff(Rogue rogue) {
    if(rogue.getHP() <= 0) {
      return;
    }
    rogue.setAngelDamageModifier(rogue.getAngelDamageModifier()
        + AngelsConstants.goodBoyBuffDmgR);
    rogue.setHP(rogue.getHP() + AngelsConstants.goodBoyBuffHpR);
    this.notifyUpdate(greatMagician, "GoodBoy helped Rogue " + rogue.getIndex() );

  }

}
