package player;

import common.player.KConstants;
import common.player.PConstants;
import common.player.RConstants;
import common.player.WConstants;
/*
 * Factory Pattern pentru crearea eroilor.
 */
public final class PlayerFactory {

  private static PlayerFactory instance = null;

  private PlayerFactory() { }

  public static PlayerFactory getInstance() {
    if (instance == null) {
      instance = new PlayerFactory();
    }
    return instance;
  }

  public Player createPlayer(final String playerType, final int hp, final int xp, final int x,
      final int y, final char terrain, final int index) {

    switch (playerType) {
      case "W": return new Wizard(playerType, WConstants.WIZARD_HP, xp, x, y, terrain, index);
      case "R": return new Rogue(playerType, RConstants.ROGUE_HP, xp, x, y, terrain, index);
      case "K": return new Knight(playerType, KConstants.KNIGHT_HP, xp, x, y, terrain, index);
      case "P": return new Pyromancer(playerType, PConstants.PYRO_HP, xp, x, y, terrain, index);
      default: return null;
    }
  }
}
