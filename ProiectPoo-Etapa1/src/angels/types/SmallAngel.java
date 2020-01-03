package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class SmallAngel extends Angel {

  public SmallAngel(final int xCoordinate, final int yCoordinate, final String type) {
    super(xCoordinate, yCoordinate, type);
  }
  private GreatMagician greatMagician = new GreatMagician();
  @Override
  public final void buff(final Pyromancer pyromancer) {
    if (pyromancer.getHP() <= 0) {
      return;
    }
    pyromancer.setAngelDamageModifier(pyromancer.getAngelDamageModifier()
        + AngelsConstants.SMALL_ANGEL_BUFF_DMG_P);
    pyromancer.setHP(pyromancer.getHP() + AngelsConstants.SMALL_ANGEL_BUFF_HP_P);
    this.notifyUpdate(greatMagician, "SmallAngel helped Pyromancer " + pyromancer.getIndex());
  }

  @Override
  public final void buff(final Knight knight) {
    if (knight.getHP() <= 0) {
      return;
    }
    knight.setAngelDamageModifier(knight.getAngelDamageModifier()
        + AngelsConstants.SMALL_ANGEL_BUFF_DMG_K);
    knight.setHP(knight.getHP() + AngelsConstants.SMALL_ANGEL_BUFF_HP_K);
    this.notifyUpdate(greatMagician, "SmallAngel helped Knight " + knight.getIndex());
  }

  @Override
  public final void buff(final Wizard wizard) {
    if (wizard.getHP() <= 0) {
      return;
    }
    wizard.setAngelDamageModifier(wizard.getAngelDamageModifier()
        + AngelsConstants.SMALL_ANGEL_BUFF_DMG_W);
    wizard.setHP(wizard.getHP() + AngelsConstants.SMALL_ANGEL_BUFF_HP_W);
    this.notifyUpdate(greatMagician, "SmallAngel helped Wizard " + wizard.getIndex());

  }

  @Override
  public final void buff(final Rogue rogue) {
    if (rogue.getHP() <= 0) {
      return;
    }
    rogue.setAngelDamageModifier(rogue.getAngelDamageModifier()
        + AngelsConstants.SMALL_ANGEL_BUFF_DMG_R);
    rogue.setHP(rogue.getHP() + AngelsConstants.SMALL_ANGEL_BUFF_HP_R);
    this.notifyUpdate(greatMagician, "SmallAngel helped Rogue " + rogue.getIndex());

  }

}
