/**
* @author: Haithem Khelif
* Team: 11
* @since: 26/02/2017 10:?? PM
*
* This class "Game.java" is the main class in order to
* have the game running all the other classe should be
* within the same directory.I made all the methods private
* because other classes must serve this class and not vice versa.
*/

import java.util.Scanner;
import java.util.Random;
public class Game2 {
/*
* Create class instances and objects.
*/
private User user = new User();
private Grid grid = new Grid();
  // public FrameTimerMain userFrameTimer = new FrameTimerMain();
  private Obstacle userObstacle = new Obstacle();
  HighScore highscoreCheck = new HighScore();

  public void gameOver(){
    int userScore = highscoreCheck.gameHasEnded();
    highscoreCheck.setUserNewScore(userScore);
    highscoreCheck.runHighScore(userScore);
  }

  public void play() {
    boolean obstacle_hit = false;
    highscoreCheck.start();
    while (!obstacle_hit) {
      grid.drawGrid(user.userMovement.getXCoord(),user.userMovement.getYCoord(),1,2,1,1);
      user.movement();
      grid.adjustGrid();
      if ((user.userMovement.isCollision(1,2)) ||( user.userMovement.isCollision(1,1))) {
        obstacle_hit = true;
        System.out.println("You hit the obstacle Game Over");
      }
    }
    this.gameOver();
  }

}