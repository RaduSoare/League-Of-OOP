package main;

public class GameLogic {

  public void gameEvolution(GameDatas gameDatas) {
    int round = 0, subround = 0;
    for(int i = 0; i < gameDatas.getNumberOfPlayers() * gameDatas.getNumberOfRounds(); i++) {
      if(subround == 0)
        System.out.println("Round: " + " " + round);
      System.out.println("Player " + subround + " will move to: " + gameDatas.getDirections()[i]);
      subround++;
      if(subround == gameDatas.getNumberOfPlayers()) {
        subround = 0;
        round++;
      }
    }
  }
}
