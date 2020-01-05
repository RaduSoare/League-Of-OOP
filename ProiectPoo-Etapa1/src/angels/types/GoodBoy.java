package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class GoodBoy extends Angel {

  private GreatMagician greatMagician = new GreatMagician();
  public GoodBoy(final int xCoordinate, final int yCoordinate, final String type) {
    super(xCoordinate, yCoordinate, type);
    this.attach(greatMagician);

  }

  @Override
  public final void buff(final Pyromancer pyromancer) {
    if (pyromancer.getHP() <= 0) {
      return;
    }
    pyromancer.setAngelDamageModifier(pyromancer.getAngelDamageModifier()
        + AngelsConstants.GOODBOY_BUFF_DMG_P);
    pyromancer.setHP(pyromancer.getHP() + AngelsConstants.GOODBOY_BUFF_HP_P);
    this.notifyUpdate(greatMagician, "GoodBoy helped Pyromancer " + pyromancer.getIndex());

  }

  @Override
  public final void buff(final Knight knight) {
    if (knight.getHP() <= 0) {
      return;
    }
    knight.setAngelDamageModifier(knight.getAngelDamageModifier()
        + AngelsConstants.GOODBOY_BUFF_DMG_K);
    knight.setHP(knight.getHP() + AngelsConstants.GOODBOY_BUFF_HP_K);
    this.notifyUpdate(greatMagician, "GoodBoy helped Knight " + knight.getIndex());

  }

  @Override
  public final void buff(final Wizard wizard) {
    if (wizard.getHP() <= 0) {
      return;
    }
    wizard.setAngelDamageModifier(wizard.getAngelDamageModifier()
        + AngelsConstants.GOODBOY_BUFF_DMG_W);
    wizard.setHP(wizard.getHP() + AngelsConstants.GOODBOY_BUFF_HP_W);
    this.notifyUpdate(greatMagician, "GoodBoy helped Wizard " + wizard.getIndex());

  }

  @Override
  public final void buff(final Rogue rogue) {
    if (rogue.getHP() <= 0) {
      return;
    }
    rogue.setAngelDamageModifier(rogue.getAngelDamageModifier()
        + AngelsConstants.GOODBOY_BUFF_DMG_R);
    rogue.setHP(rogue.getHP() + AngelsConstants.GOODBOY_BUFF_HP_R);
    this.notifyUpdate(greatMagician, "GoodBoy helped Rogue " + rogue.getIndex());

  }

}
