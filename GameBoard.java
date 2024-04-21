package battleship;

public class GameBoard {

    public void printOverview(Battlefield field1, Battlefield field2) {
        field1.printBattlefieldFogged();
        System.out.println("---------------------");
        field2.printBattlefield();
    }

}
