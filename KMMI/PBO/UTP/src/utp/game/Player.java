package utp.game;

import utp.game.Character;

public class Player extends Character{
    // default value
    private final int originalAttPower = 36;
    private final int attPowerDecrement = 11;

    // constructor
    public Player(String name) {
        // set value
        if(name.equals("")  || name.equals(" ")) this.setName("Player");
        else this.setName(name);
        this.setHealth(100);
        this.setAttackPower(36);
        
    }

    public int getOriginalAttPower() {
        return originalAttPower;
    }

    public int getAttPowerDecrement() {
        return attPowerDecrement;
    }
    
    
    @Override
    public String attack(Character character){
        
        String attackMessages = ">> Giliran " + this.getName() + "\n";
        
        // jika power <= 0 maka tidak bisa attack && health -5 
        if(this.getAttackPower() <= 0){
            
            this.setHealth(this.getHealth() - 5);
            attackMessages = "Kamu kecapean! butuh istirahat!\n"
                    + "Kesehatan kamu -5 \nKesehatan kamu sekarang " + this.getHealth() + "\n";
            
        } else {
            int monsterCurrentHealth = character.getHealth(); // ambil health monster
            
            // logic biar monster health / jumlah bug gk minus
            if ((monsterCurrentHealth - this.getAttackPower()) >= 0){
                character.setHealth(monsterCurrentHealth - this.getAttackPower());
            
            } else {
                character.setHealth(0);
            }
            attackMessages = String.format("%s membasmi %s!", this.getName(), character.getName()) + "\n"
                    + String.format("%s -%d", character.getName(), this.getAttackPower()) +"\n"
                    + String.format("%s tersisa : %d", character.getName(), character.getHealth()) + "\n";
            
            // logic biar attack power player gk minus
            if((this.getAttackPower() - attPowerDecrement) < 0) {
                this.setAttackPower(0);
            } else {
                this.setAttackPower(this.getAttackPower() - attPowerDecrement);
            }
            attackMessages = attackMessages + String.format("%s PowerOfDebug (-%d) -> %d \n", 
                    this.getName(), this.attPowerDecrement, this.getAttackPower());
            
        }
        return attackMessages;
    } 
    
    // player dapat memulihkan tenaga
    
    @Override
    public String defend(){
        this.setAttackPower(this.originalAttPower);
        this.setHealth(this.getHealth() + 20);
        String defMessages = ">> Giliran " + this.getName() + "\n"
                + "Pemulihan berhasil!"
                + "\nKesehatan +20 & kekuatan debug telah pulih"
                + "\nPowerOfDebug : " + this.getAttackPower()
                + "\nKesehatan : " + this.getHealth()
                + "\n";
        return defMessages;
    }
    
    
}
