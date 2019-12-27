package player.strategy;

import player.Player;

public interface PlayerStrategy {

  public void damageStrategy(Player player);
  public void hpStrategy(Player player);
  public void strategySelection(Player player);
}
