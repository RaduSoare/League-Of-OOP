package angels.types;

import angels.Angel;
import common.angel.AngelsConstants;
import observer.GreatMagician;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;
import utility.FullNameProvider;

public class Dracula extends Angel {

  private GreatMagician greatMagician = new GreatMagician();
  public Dracula(final int xCoordinate, final int yCoordinate, final String type) {
    super(xCoordinate, yCoordinate, type);
    this.attach(greatMagician);
  }
  /*
   * Modifica atat modificatorii de rasa cat si HP-ul jucatorului.
   */
  @Override
  public final void buff(final Pyromancer pyromancer) {
    if (pyromancer.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "Dracula hit Pyromancer " + pyromancer.getIndex());
    pyromancer.setAngelDamageModifier(pyromancer.getAngelDamageModifier()
        + AngelsConstants.DRACULA_BUFF_DMG_P);
    pyromancer.setHP(pyromancer.getHP() - AngelsConstants.DRACULA_BUFF_HP_P);
    if (pyromancer.getHP() <= 0) {
      pyromancer.setHP(0);
      this.notifyUpdate(greatMagician, "Player "
      + FullNameProvider.getFullName(pyromancer.getType()) + " " + pyromancer.getIndex()
      + " was killed by an angel");
    }


  }

  @Override
  public final void buff(final Knight knight) {
    if (knight.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "Dracula hit Knight " + knight.getIndex());
    knight.setAngelDamageModifier(knight.getAngelDamageModifier()
        + AngelsConstants.DRACULA_BUFF_DMG_K);
    knight.setHP(knight.getHP() - AngelsConstants.DRACULA_BUFF_HP_K);
    if (knight.getHP() <= 0) {
      knight.setHP(0);
      this.notifyUpdate(greatMagician, "Player "
      + FullNameProvider.getFullName(knight.getType()) + " " + knight.getIndex()
      + " was killed by an angel");
    }

  }

  @Override
  public final void buff(final Wizard wizard) {
    if (wizard.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "Dracula hit Wizard " + wizard.getIndex());
    wizard.setAngelDamageModifier(wizard.getAngelDamageModifier()
        + AngelsConstants.DRACULA_BUFF_DMG_W);
    wizard.setHP(wizard.getHP() - AngelsConstants.DRACULA_BUFF_HP_W);
    if (wizard.getHP() <= 0) {
      wizard.setHP(0);
      this.notifyUpdate(greatMagician, "Player "
      + FullNameProvider.getFullName(wizard.getType()) + " "  + wizard.getIndex()
      + " was killed by an angel");
    }


  }

  @Override
  public final void buff(final Rogue rogue) {
    if (rogue.getHP() <= 0) {
      return;
    }
    this.notifyUpdate(greatMagician, "Dracula hit Rogue " + rogue.getIndex());
    rogue.setAngelDamageModifier(rogue.getAngelDamageModifier()
        + AngelsConstants.DRACULA_BUFF_DMG_R);
    rogue.setHP(rogue.getHP() - AngelsConstants.DRACULA_BUFF_HP_R);
    if (rogue.getHP() <= 0) {
      rogue.setHP(0);
      this.notifyUpdate(greatMagician, "Player "
      + FullNameProvider.getFullName(rogue.getType()) + " " + rogue.getIndex()
      + " was killed by an angel");
    }

  }

}
