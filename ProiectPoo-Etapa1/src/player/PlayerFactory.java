package player;

import common.Constants;
import common.RConstants;
import common.WConstants;

public class PlayerFactory {

  private static PlayerFactory instance = null;

  private PlayerFactory() { }

  static public PlayerFactory getInstance() {
    if(instance == null) {
      instance = new PlayerFactory();
    }
    return instance;
  }

  public Player createPlayer(final String playerType, final int hp, final int xp, final int x,
      final int y, final char terrain) {
    switch(playerType) {
    case "W": return new Wizard(playerType, WConstants.getWizardHp(), xp, x, y, terrain);
    case "R": return new Rogue(playerType, RConstants.getRogueHp(), xp, x, y, terrain);
    case "K": return new Knight(playerType, Constants.getKnightHp(), xp, x, y, terrain);
    case "P": return new Pyromancer(playerType, Constants.getPyromancerHp(), xp, x, y, terrain);
    default: return null;
    }
  }
}
