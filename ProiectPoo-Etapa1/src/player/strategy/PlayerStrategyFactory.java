package player.strategy;

public class PlayerStrategyFactory {

  public PlayerStrategy createPlayerStrategy(String playerType) {

    switch(playerType) {
    case "K":
      return new KnightStrategy();
    case "P":
      return new PyromancerStrategy();
    case "R":
      return new RogueStrategy();
    case "W":
      return new WizardStrategy();
    default:
      return null;
    }
  }
}
