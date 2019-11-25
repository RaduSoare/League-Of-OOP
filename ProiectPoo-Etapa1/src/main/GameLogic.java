package main;

import gameMechanism.AfterFightCalculator;
import gameMechanism.PlayersMovement;
import map.Map;
import map.Terrain;
import player.Player;

public class GameLogic {

  public void gameEvolution(GameDatas gameDatas) {

    Map mapInstance = Map.getInstance();
    Terrain[][] map = mapInstance.createMap(gameDatas.getRealm(), gameDatas.getPlayers(), gameDatas.getN(), gameDatas.getM());
    PlayersMovement playerMovement = new PlayersMovement();
    AfterFightCalculator afterFightCalculator = new AfterFightCalculator();

    for(int round = 0; round < gameDatas.getNumberOfRounds(); round++) {
      playerMovement.movePlayers(gameDatas, round, map);
      System.out.println("RUNDA " + round);
     for(int i = 0; i < gameDatas.getN(); i++) {
       for(int j = 0; j < gameDatas.getM(); j++) {
         // daca exista 2 jucatori pe acelasi teren, acestia se lupta
         if(map[i][j].getPlayersOnTerrain().size() == 2) {
           Player player1, player2;


           // ma asigur ca wizard e al doilea care ataca
           if(map[i][j].getPlayersOnTerrain().get(0).getType().equals("W")) {
               player1 = map[i][j].getPlayersOnTerrain().get(0);
               player2 = map[i][j].getPlayersOnTerrain().get(1);
           } else {
               player1 = map[i][j].getPlayersOnTerrain().get(1);
               player2 = map[i][j].getPlayersOnTerrain().get(0);
           }
           //DoT

           player1.setHP(player1.getHP() - player1.getOvertimeDamage());
           if(player1.getOvertimeDuration() > 0) {
             player1.setOvertimeDuration(player1.getOvertimeDuration() - 1);
           }
           if(player1.getOvertimeDuration() == 0) {
             player1.setOvertimeDamage(0);
             player1.setParalysed(false);
           }

           player2.setHP(player2.getHP() - player2.getOvertimeDamage());
           if(player2.getOvertimeDuration() > 0) {
             player2.setOvertimeDuration(player2.getOvertimeDuration() - 1);
           }
           if(player2.getOvertimeDuration() == 0) {
             player2.setOvertimeDamage(0);
             player2.setParalysed(false);
           }

           if(player1.getHP() > 0 && player2.getHP() > 0) {
          /*   System.out.println(player1.getType() + ": " + player1.getHP() + " " +
                 player2.getType() + ": " + player2.getHP() ); */
             player1.fightsWith(player2);
             player2.fightsWith(player1);
             afterFightCalculator.afterFightStatus(player1, player2, map, gameDatas);
        /*     System.out.println(player1.getType() + ": " + player1.getHP() + " " +
                 player2.getType() + ": " + player2.getHP() ); */

           }


         }

       }

     }


    }






  }

}
