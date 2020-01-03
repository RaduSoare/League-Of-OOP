
package gamemechanism;

import main.GameDatas;
import map.Terrain;
import observer.GreatMagician;
import player.Player;
import utility.FullNameProvider;

public class AfterFightCalculator {

  public final void afterFightStatus(final Player player1, final Player player2,
      final Terrain[][] map, final GameDatas gameDatas, final GreatMagician greatMagician) {

    LevelUpCalculator levelUpCalculator = new LevelUpCalculator();
    XpCalculator xpCalculator = new XpCalculator();

    // setez damage-ul primit de fiecare
    player1.setDamageTaken(player2.getDamageGiven());
    player2.setDamageTaken(player1.getDamageGiven());

    // calculez HP-ul dupa lupta
    applyDamage(player1, player2, greatMagician);
    applyDamage(player2, player1, greatMagician);

    Player winner = null, loser = null;
    if (player1.getHP() <= 0) {
      winner = player2;
      loser = player1;
    } else if (player2.getHP() <= 0) {
      winner = player1;
      loser = player2;
    }

   if ((winner != null || loser != null) && winner.getHP() > 0) {
      xpCalculator.computeXp(winner, loser);
      levelUpCalculator.computeLevelUp(winner);
    }
   }

  public final void applyDamage(final Player player1, final Player player2,
      final GreatMagician greatMagician) {

    player1.setHP(player1.getHP() - player1.getDamageTaken());
    if (player1.getHP() <= 0) {
      player1.setHP(0);
      player1.notifyUpdate(greatMagician, "Player "
      + FullNameProvider.getFullName(player1.getType()) + " " + player1.getIndex()
      + " was killed by " + FullNameProvider.getFullName(player2.getType()) + " "
      + player2.getIndex());
    }
  }
}
