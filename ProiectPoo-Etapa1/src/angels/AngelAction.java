package angels;

import java.util.LinkedList;

import main.GameDatas;
import map.Terrain;
import observer.GreatMagician;
import player.Player;

public class AngelAction {

  public AngelAction() {
  }

  public final void buffPlayers(final GameDatas gameDatas, final int round, final Terrain[][] map,
      final GreatMagician greatMagician) {

    for (int i = 0; i < gameDatas.getAngels().get(round).size(); i++) {

      Angel tempAngel = gameDatas.getAngels().get(round).get(i);

      // notificare observer
      tempAngel.notifyUpdate(greatMagician, "Angel " + tempAngel.getType() + " was spawned at "
      + tempAngel.getxCoordinate() + " " + tempAngel.getyCoordinate());

      LinkedList<Player> tempPlayers = map[tempAngel.getxCoordinate()]
          [tempAngel.getyCoordinate()].getPlayersOnTerrain();
      if (tempPlayers.size() > 0) {
        for (Player x : tempPlayers) {
          x.getBuff(gameDatas.getAngels().get(round).get(i));
        }
      }
    }
  }

}
