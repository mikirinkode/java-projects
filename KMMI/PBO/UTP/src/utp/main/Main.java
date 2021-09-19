package utp.main;

import utp.game.Player;
import utp.game.Monster;
import utp.game.Game;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String title = "Game: Fix the Bugs!";
        
        Game game = new Game();
        
        String playerName = JOptionPane.showInputDialog(null, "Masukan Nama anda", title, 3);
        System.out.println("Nama terpilih : " + playerName);
       
        Player player = new Player(playerName);
        Monster monster = new Monster();
       
        game.start(player, monster);
    }
}
