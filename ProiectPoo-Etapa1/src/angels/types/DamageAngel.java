package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class DamageAngel extends Angel {

  private GreatMagician greatMagician = new GreatMagician();
  public DamageAngel(final int xCoordinate, final int yCoordinate, final String type) {
    super(xCoordinate, yCoordinate, type);
    this.attach(greatMagician);

  }

  /*
   * Schimba modificatorii de damage in functie de rasa.
   */
  @Override
  public final void buff(final Pyromancer pyromancer) {
    if (pyromancer.getHP() <= 0) {
      return;
    }
    pyromancer.setAngelDamageModifier(pyromancer.getAngelDamageModifier()
        + AngelsConstants.DAMAGE_ANGEL_BUFF_P);
    this.notifyUpdate(greatMagician, "DamageAngel helped Pyromancer " + pyromancer.getIndex());

  }

  @Override
  public final void buff(final Knight knight) {
    if (knight.getHP() <= 0) {
      return;
    }
    knight.setAngelDamageModifier(knight.getAngelDamageModifier()
        + AngelsConstants.DAMAGE_ANGEL_BUFF_K);
    this.notifyUpdate(greatMagician, "DamageAngel helped Knight " + knight.getIndex());
  }

  @Override
  public final void buff(final Wizard wizard) {
    if (wizard.getHP() <= 0) {
      return;
    }
    wizard.setAngelDamageModifier(wizard.getAngelDamageModifier()
        + AngelsConstants.DAMAGE_ANGEL_BUFF_W);
    this.notifyUpdate(greatMagician, "DamageAngel helped Wizard " + wizard.getIndex());

  }

  @Override
  public final void buff(final Rogue rogue) {
    if (rogue.getHP() <= 0) {
      return;
    }
    rogue.setAngelDamageModifier(rogue.getAngelDamageModifier()
        + AngelsConstants.DAMAGE_ANGEL_BUFF_R);
    this.notifyUpdate(greatMagician, "DamageAngel helped Rogue " + rogue.getIndex());

  }




}
