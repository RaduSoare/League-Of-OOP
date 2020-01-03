package player.strategy;

import player.Player;

public interface PlayerStrategy {

  void damageStrategy(Player player);
  void hpStrategy(Player player);
  void strategySelection(Player player);
}
