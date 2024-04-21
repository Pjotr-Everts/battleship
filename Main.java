package battleship;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // general objects
        Scanner scanner = new Scanner(System.in);
        ShipTypes[] ships = new ShipTypes[]{ShipTypes.CARRIER, ShipTypes.BATTLESHIP, ShipTypes.SUBMARINE,ShipTypes.CRUISER, ShipTypes.DESTROYER};

        // player 1 places all ships
        System.out.printf("Player 1, place your ships on the game field%n%n");
        Battlefield battlefieldPlayerOne = new Battlefield(10, 10);
        Place placeShipsPlayerOne = new Place(battlefieldPlayerOne, scanner);
        battlefieldPlayerOne.printBattlefield();

        for (ShipTypes ship : ships) {
            placeShipsPlayerOne.placeShip(ship);
            System.out.println();
            battlefieldPlayerOne.printBattlefield();
        }

        Pass.passTurn(scanner);

        // player 2 places all ships
        System.out.printf("Player 2, place your ships on the game field%n%n");
        Battlefield battlefieldPlayerTwo = new Battlefield(10, 10);
        Place placeShipsPlayerTwo = new Place(battlefieldPlayerTwo, scanner);
        battlefieldPlayerTwo.printBattlefield();

        for (ShipTypes ship : ships) {
            placeShipsPlayerTwo.placeShip(ship);
            System.out.println();
            battlefieldPlayerTwo.printBattlefield();
        }

        Pass.passTurn(scanner);

        // start playing the game
        GameBoard gameboard = new GameBoard();
        Hits hitsPlayerOne = new Hits();
        Hits hitsPlayerTwo = new Hits();
        Play playTheGame = new Play();

        playTheGame.playGame(battlefieldPlayerOne, battlefieldPlayerTwo, hitsPlayerOne, hitsPlayerTwo, gameboard, scanner);

        scanner.close();
    }

}