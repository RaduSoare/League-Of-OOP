package player.strategy;

import map.Terrain;
import player.Player;

public class StrategyApplier {

  public StrategyApplier() {

  }
  /*
   * La parcugerea hartii, se aplica strategia fiecarui jucator viu si neincapacitat
   * de pe terenul respectiv.
   */
  public final void applyStrategy(final Terrain[][] map, final int i, final int j) {
    PlayerStrategyFactory strategyFactory = new PlayerStrategyFactory();

    for (Player x : map[i][j].getPlayersOnTerrain()) {
      if (!x.isParalysed() && x.getHP() > 0) {
        PlayerStrategy strategy = strategyFactory.createPlayerStrategy(x.getType());
        strategy.strategySelection(x);
      }
    }
  }
}
