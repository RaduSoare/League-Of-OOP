package main;

import angels.AngelAction;
import gamemechanism.AfterFightCalculator;
import gamemechanism.OvertimeCalculator;
import gamemechanism.PlayersMovement;
import map.Map;
import map.Terrain;
import observer.GreatMagician;
import player.Player;
import player.strategy.StrategyApplier;
import utility.FileLineWriter;

public class GameLogic {

  public final void gameEvolution(final GameDatas gameDatas, final String pathIn,
      final String pathOut) {
    // se creeaza harta pe baza inputului
    Map mapInstance = Map.getInstance();
    Terrain[][] map = mapInstance.createMap(gameDatas.getRealm(), gameDatas.getPlayers(),
        gameDatas.getN(), gameDatas.getM());
    PlayersMovement playerMovement = new PlayersMovement();
    AfterFightCalculator afterFightCalculator = new AfterFightCalculator();
    OvertimeCalculator overtimeCalculator = new OvertimeCalculator();
    AngelAction angelAction = new AngelAction();
    StrategyApplier strategyApplier = new StrategyApplier();
    GreatMagician greatMagician = new GreatMagician();




    for (int round = 0; round < gameDatas.getNumberOfRounds(); round++) {
    //  System.out.println("~~ Round " + (round + 1) + " ~~");
      FileLineWriter.writeLine("~~ Round " + (round + 1) + " ~~", pathOut);

     // se realizeaza miscarea jucatorilor pe harta
     playerMovement.movePlayers(gameDatas, round, map);

     for (int i = 0; i < gameDatas.getN(); i++) {
       for (int j = 0; j < gameDatas.getM(); j++) {
         // se aplica strategia necesara
         strategyApplier.applyStrategy(map, i, j);
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
         //    System.out.println("Damage before fight:" + player1.getHP() + " " + player2.getHP());
             player1.fightsWith(player2);
             player2.fightsWith(player1);
             afterFightCalculator.afterFightStatus(player1, player2, map, gameDatas, greatMagician);
         //   System.out.println("Damage after fight:" + player1.getHP() + " " + player2.getHP());


           }
         }
       }
     }
     //Angel buff
     angelAction.buffPlayers(gameDatas, round, map, greatMagician);
     FileLineWriter.writeLine("", pathOut);
    }

  }
}
