package player.strategy;

import map.Terrain;
import player.Player;

public class StrategyApplier {

  public StrategyApplier() {

  }
  /*   PlayerStrategy strategy = strategyFactory.createPlayerStrategy(x.getType());
  strategy.strategySelection(x); */

 /* public void applyStrategy(final Terrain[][] map, final GameDatas gameDatas) {
    PlayerStrategyFactory strategyFactory = new PlayerStrategyFactory();
    for (int i = 0; i < gameDatas.getN(); i++) {
      for(int j = 0; j < gameDatas.getM(); j++) {
        if(!map[i][j].getPlayersOnTerrain().isEmpty() && map[i][j].getPlayersOnTerrain().size() != 0) {
          LinkedList<Player> temp = map[i][j].getPlayersOnTerrain();
          for(Player x  : temp) {
            PlayerStrategy strategy = strategyFactory.createPlayerStrategy(x.getType());
            strategy.strategySelection(x);
          }
        }
      }
    }
  } */

  public final void applyStrategy(final Terrain[][] map, final int i, final int j) {
    PlayerStrategyFactory strategyFactory = new PlayerStrategyFactory();
    for (Player x : map[i][j].getPlayersOnTerrain()) {
      if(x.isParalysed() == false && x.getHP() > 0) {
        PlayerStrategy strategy = strategyFactory.createPlayerStrategy(x.getType());
        strategy.strategySelection(x);
      }
    }
  }
}
