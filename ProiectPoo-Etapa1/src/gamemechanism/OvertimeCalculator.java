package gamemechanism;

import map.Terrain;
import player.Player;

public class OvertimeCalculator {

  /*
   * Scade din HP-ul jucatorilor DOT-ul primit anterior, daca este cazul.
   */
  public final void computeOvertimeValues(final Terrain[][] map, final int i, final int j) {

    for (Player x : map[i][j].getPlayersOnTerrain()) {

      if (map[i][j].getPlayersOnTerrain().size() != 0 && x.getOvertimeDuration() > 0) {

        x.setOvertimeDuration(x.getOvertimeDuration() - 1);
        x.setHP(x.getHP() - x.getOvertimeDamage());

        if (x.getOvertimeDuration() == 0) {
          x.setParalysed(false);
          x.setOvertimeDamage(0);
        }

      }
    }
  }
}
