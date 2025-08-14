package Code.LeetCode.TicTacToe;

public class Main {


    public static void main(String args[]){
        Player p1 = new Player("Shyam" , Symbol.X);
        Player p2 = new Player("Apoorva" , Symbol.O);
        Player p3 = new Player("chandan" , Symbol.S);


        Game game = new Game(p1, p2 , p3 , 3);
        game.start();
    }
}
