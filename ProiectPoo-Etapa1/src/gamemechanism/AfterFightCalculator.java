
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

    // seteaza damage-ul primit de fiecare
    player1.setDamageTaken(player2.getDamageGiven());
    player2.setDamageTaken(player1.getDamageGiven());


    // calculeza HP-ul dupa lupta
    applyDamage(player1, player2, greatMagician);
    applyDamage(player2, player1, greatMagician);

    // caz omor reciproc
    if(player1.getHP() <= 0 && player2.getHP() <= 0) {
      int player2OldLevel = player2.getLevel();

      xpCalculator.computeXp(player2, player1.getLevel());
      levelUpCalculator.computeLevelUp(player2);

      xpCalculator.computeXp(player1, player2OldLevel);
      levelUpCalculator.computeLevelUp(player1);

      player1.setHP(0);
      player2.setHP(0);
      return;
    }


    // decide invingatorul
    Player winner = null, loser = null;
    if (player1.getHP() <= 0) {
      winner = player2;
      loser = player1;
    } else if (player2.getHP() <= 0) {
      winner = player1;
      loser = player2;
    }
    // calculeaza noua experienta si noul level dupa lupta, daca unul dintre jucatori castiga
    if ((winner != null || loser != null)) {
      xpCalculator.computeXp(winner, loser.getLevel());
      levelUpCalculator.computeLevelUp(winner);
    }

   }
  /*
   * Scade din HP-ul primul jucator, damage-ul primit de la cel de-al doilea.
   */
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
