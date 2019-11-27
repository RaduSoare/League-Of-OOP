package main;

import gamemechanism.AfterFightCalculator;
import gamemechanism.OvertimeCalculator;
import gamemechanism.PlayersMovement;
import map.Map;
import map.Terrain;
import player.Player;

public class GameLogic {

  public final void gameEvolution(final GameDatas gameDatas) {
    // se creeaza harta pe baza inputului
    Map mapInstance = Map.getInstance();
    Terrain[][] map = mapInstance.createMap(gameDatas.getRealm(), gameDatas.getPlayers(),
        gameDatas.getN(), gameDatas.getM());
    PlayersMovement playerMovement = new PlayersMovement();
    AfterFightCalculator afterFightCalculator = new AfterFightCalculator();
    OvertimeCalculator overtimeCalculator = new OvertimeCalculator();

    for (int round = 0; round < gameDatas.getNumberOfRounds(); round++) {
     // se realizeaza miscarea jucatorilor pe harta
     playerMovement.movePlayers(gameDatas, round, map);

     for (int i = 0; i < gameDatas.getN(); i++) {
       for (int j = 0; j < gameDatas.getM(); j++) {
         // se aplica damage-ul "overtime"
         overtimeCalculator.computeOvertimeValues(map, i, j);

         /*
          * se verifica daca exista 2 jucatori pe un teren
          * daca exista, are loc lupta
          */
         if (map[i][j].getPlayersOnTerrain().size() == 2) {
           Player player1, player2;


           // se asigura faptul ca eroul Wizard ataca mereu al doilea
           if (map[i][j].getPlayersOnTerrain().get(0).getType().equals("W")) {
               player1 = map[i][j].getPlayersOnTerrain().get(0);
               player2 = map[i][j].getPlayersOnTerrain().get(1);
           } else {
               player1 = map[i][j].getPlayersOnTerrain().get(1);
               player2 = map[i][j].getPlayersOnTerrain().get(0);
           }

           if (player1.getHP() > 0 && player2.getHP() > 0) {

             player1.fightsWith(player2);
             player2.fightsWith(player1);
             afterFightCalculator.afterFightStatus(player1, player2, map, gameDatas);
           }
         }
       }
     }
    }
  }
}
