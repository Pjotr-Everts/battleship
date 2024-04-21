package battleship;
import java.util.Scanner;

public class Play {

    int turnCounter = 0;
    int currentHits = 0;

    public void playGame(Battlefield battlefieldPlayerOne, Battlefield battlefieldPlayerTwo, Hits hitsPlayerOne, Hits hitsPlayerTwo, GameBoard gameboard, Scanner scanner) {

        Turn turnPlayerOne = new Turn();
        Turn turnPlayerTwo = new Turn();

        while (hitsPlayerOne.getTotalNrOfHits() < 17 || hitsPlayerTwo.getTotalNrOfHits() < 17) {
            if (turnCounter % 2 == 0) {
                gameboard.printOverview(battlefieldPlayerTwo, battlefieldPlayerOne);
                System.out.printf("%nPlayer 1, it's your turn:%n%n");
                boolean playerTwoIsHit = turnPlayerTwo.turn(battlefieldPlayerTwo, hitsPlayerTwo, scanner);
                if (playerTwoIsHit) {
                    currentHits = hitsPlayerTwo.getTotalNrOfHits();
                    hitsPlayerTwo.setTotalNrOfHits(currentHits + 1);
                }
                turnCounter++;
                currentHits = 0;
                Pass.passTurn(scanner);
            } else {
                gameboard.printOverview(battlefieldPlayerOne, battlefieldPlayerTwo);
                System.out.printf("%nPlayer 2, it's your turn:%n%n");
                boolean playerOneIsHit = turnPlayerOne.turn(battlefieldPlayerOne, hitsPlayerOne, scanner);
                if (playerOneIsHit) {
                    currentHits = hitsPlayerOne.getTotalNrOfHits();
                    hitsPlayerOne.setTotalNrOfHits(currentHits + 1);
                }
                turnCounter++;
                currentHits = 0;
                Pass.passTurn(scanner);
            }
        }
        //System.out.println("You sank the last ship. You won. Congratulations!");
    }

}
