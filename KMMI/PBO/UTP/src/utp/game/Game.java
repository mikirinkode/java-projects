package utp.game;

import java.util.Random;
import javax.swing.JOptionPane;
import utp.musicplayer.MusicPlayer;

/*
*   >> Credit music
*   Original Theme from Marvel’s “The Avengers”
*   Composed by Alan Silvestri
*/

public class Game {
    
    private final String title = "Game: Fix the Bugs!";
    private String pilihan;
    private final String[] menu = {"Perbaiki Bug", "Istirahat", "Informasi Player", "Exit"};
    private boolean play = true;
    private boolean skipMonster = false;
    private int loopCounter = 0;
    private String backgroundMusic = "AvengersThemeRemixFull.wav"; // file path backgground music
    private String winSFX = "WinSFX.wav";
    private String loseSFX = "LoseSFX.wav";
    
    
    MusicPlayer musicPlayer = new MusicPlayer();
    
    public Game(){
        // background music
        
        musicPlayer.playMusic(backgroundMusic);
        musicPlayer.loopMusic();
        
        JOptionPane.showMessageDialog(null, 
                "Selamat datang di permainan\n"
              + "> > > \"Fix The Bugs!\" < < <", 
                title, 1);
    }
    
    public void start(Player player, Monster monster) {
        Random rand = new Random();
        showHowToPlay();
        
        System.out.println("Game Start!");
        
        MENU:
        while (play) {
            showMenu(player, monster);
            skipMonster = false;
            
            if (pilihan != null) {
                switch (pilihan) {
                    case "Perbaiki Bug":
                        attack(player, monster);
                        break;
                        
                    case "Istirahat":
                        defend(player, monster);
                        break;
                        
                    case "Informasi Player":
                        JOptionPane.showMessageDialog(null,
                                player.cetakAttributes(),
                                title, 1);
                        skipMonster = true;
                        break;
                        
                    case "Exit":
                        System.out.println("Hasil Akhir :");
                        printAttributes(player, monster);
                        System.out.println("\nGame Ended");
                        break MENU;
                        
                    default:
                        break;
                }
            }
            
            if(play && !skipMonster && !pilihan.equals("3")){
                int[] monsterPattern = {0, 1, 1, 0, 1, 0, 1};
                int x = rand.nextInt(2); // method acak biar monster bisa defend / attack
                int pattern = this.getLoopCounter();
                if(x == 0){
                    // laporan di konsol
                    System.out.println(">> Monster menyerang");
                    JOptionPane.showMessageDialog(null,
                            monster.attack(player) + "\n\n"
                                    + printAttributes(player, monster), title, 1);
                } else if (x == 1){
                    // laporan di konsol
                    System.out.println(">> Monster bertahan");
                    JOptionPane.showMessageDialog(null, monster.defend() + "\n\n"
                                    + printAttributes(player, monster),title, 1);
                    
                }
                this.setLoopCounter(this.getLoopCounter() + 1);
                winConditionCheck(player, monster);
                
            }
        } // end of while play
       
    } // end of start method

    
    // menampilkan menu
    public void showMenu(Player player, Monster monster){
        // pesan di konsol
        System.out.println("Menampilkan menu");
        
        pilihan = (String) JOptionPane.showInputDialog(null, 
                printAttributes(player, monster) 
                        + "\n>> Giliran kamu!", 
                title, 3, null, menu, menu[0]);
    }
    
    public void showHowToPlay(){
        // pesan di konsol
        System.out.println("Menampilkan how to play");
        
        String howToPlay = "Cara Bermain\n"
                + "# Kamu akan bermain sebagai Programmer.\n"
                + "# Kamu harus menghapus semua bug yang ada pada program.\n"
                + "# Kunci kemenangan mu adalah ketika kamu :\n"
                + "# 1. Berhasil menghapus semua bugs\n"
                + "# 2. Berhasil menjaga kesehatan\n"
                + "# 3. Lakukan secepat mungkin \n"
                + "# GoodLuck!\n"
                + "# Tap OK to Play!\n";
        
        JOptionPane.showMessageDialog(null,
                howToPlay, 
                title, 1);
    }
    
    public void attack(Player player, Monster monster){
        // pesan di konsol
        System.out.println(">> " + player.getName() + " menyerang");
        
        JOptionPane.showMessageDialog(null,
                player.attack(monster) + "\n\n" + printAttributes(player, monster),
                title, 1);
        
        
        winConditionCheck(player, monster);
    }
    
    public void defend(Player player, Monster monster){
        // pesan di konsol
        System.out.println(">> " + player.getName() + " bertahan");
        
        JOptionPane.showMessageDialog(null,
                player.defend() + "\n\n" + printAttributes(player, monster),
                title, 1);
        
        winConditionCheck(player, monster);
    }
    
    // ngecek menang 
    public void winConditionCheck(Player player, Monster monster) {
        if(player.getHealth() <= 0){
            winDialog(player, monster, "monster");
        } else if (monster.getHealth() <= 0){
            winDialog(player, monster, "player");
        } 
    }
    
    public void winDialog(Player player, Monster monster, String winner){
        // stop background music 
        musicPlayer.stopMusic();
        
        // pesan di konsol
        System.out.println("game selesai.");
        System.out.println(">> pemenang " + winner);
        
        String winDialogMessage = ">> Game ended. \n"
                + "Hasil akhir : \n"
                + printAttributes(player, monster)
                + "\n >> ";
        
        if (winner == "player"){
            // play sfx
            musicPlayer.playMusic(winSFX);
            
            winDialogMessage += (player.getName() + " Win\n\n");
            winDialogMessage += youWin();
        } 
        else if (winner == "monster"){
            // play sfx
            musicPlayer.playMusic(loseSFX);
            
            winDialogMessage += (monster.getName() + " Win\n\n");
            winDialogMessage += youLose();
        }
        JOptionPane.showMessageDialog(null, winDialogMessage, title, 1);
        play = false;
        
    }
    
    
    public String printAttributes(Player player, Monster monster) {
        // pesan di konsol
        System.out.println("menampilkan status");
        
        String space = "";
        String attributes = ""
                + "===================== Report =====================\n"
                + String.format("%s %"+ (56 - player.getName().length()) +"s", player.getName(), monster.getName()) + "\n"
                + String.format("Kesehatan : %d %"+(31) +"s JumlahBug : %d", player.getHealth(), space, monster.getHealth()) + "\n"
                + String.format("PowerOfDebug : %d %"+(23) +"s PowerOfSpread : %d", player.getAttackPower(), space, monster.getBabyBugs()) + "\n"
                + "==================================================\n";
        return attributes;
    }
    
    public String youWin(){
        String winText = ""
                + "##   ##   ###    ##  ##      ##      ##  ####  ##    ##     \n"
                + " ## ##   ## ##   ##  ##      ##      ##   ##   ###   ##     \n"
                + "  ##    ##   ##  ##  ##      ##      ##   ##   ## ## ##     \n"
                + "  ##     ## ##   ##  ##      ##  ##  ##   ##   ##   ###     \n"
                + "  ##      ###    ######       ##    ##   ####  ##    ##     \n";
        winText = winText.replaceAll(" ", "  ");
        return winText;
    }
    public String youLose(){
        String loseText = ""
                + "##   ##   ###    ##  ##      ##      ###    #####  #####     \n"
                + " ## ##   ## ##   ##  ##      ##     ## ##   ##     ##        \n"
                + "  ##    ##   ##  ##  ##      ##    ##   ##  #####  #####     \n"
                + "  ##     ## ##   ##  ##      ##     ## ##      ##  ##        \n"
                + "  ##      ###    ######      #####   ###    #####  #####     \n";
        loseText = loseText.replaceAll(" ", "  ");
        return loseText;
    }

    public int getLoopCounter() {
        return loopCounter;
    }

    public void setLoopCounter(int loopCounter) {
        this.loopCounter = loopCounter;
    }
    
    
}

