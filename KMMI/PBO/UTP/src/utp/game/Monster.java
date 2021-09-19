package utp.game;

import utp.game.Character;
import java.util.Random;


public class Monster extends Character{
    
    private int spreadingBonus = 0;
    private int babyBugs; // untuk menampung bugs baru
    Random random = new Random();
    
    public Monster(){
        // default value
        this.setName("Bug");
        this.setHealth(100);
        this.setAttackPower(18);
    }

    public int getSpreadingBonus() {
        return spreadingBonus;
    }

    public void setSpreadingBonus(int spreadingBonus) {
        this.spreadingBonus = spreadingBonus;
    }

    public int getBabyBugs() {
        
        return babyBugs;
    }

    public int getNewBabyBugs() {
        babyBugs = (7 + random.nextInt(10));  // random attack power 7 - 16
        return babyBugs;
    }

    public void setBabyBugs(int babyBugs) {
        this.babyBugs = babyBugs;
    }
    
    
    
    

    @Override
    public String attack(Character character){
        this.getNewBabyBugs();
        String attackMessages = ">> Giliran " + this.getName() + "\n";
        
        
        this.setAttackPower((this.getBabyBugs() * 2) + this.spreadingBonus + 7);
        this.setHealth(this.getHealth() + (this.getBabyBugs() + this.spreadingBonus)); // set power penyebaran monster = current value + random angka + bonus
        
        
        int playerCurrentHealth = character.getHealth();
        
        // logic biar health player gk minus
        if((playerCurrentHealth - this.getAttackPower()) > 0) {
            character.setHealth(playerCurrentHealth - this.getAttackPower());
        }
        else {
            character.setHealth(0);
        }
        
        attackMessages = attackMessages + String.format("%s menyerang program! \n", this.getName());
        if(this.spreadingBonus > 0){
            attackMessages = attackMessages + String.format("[%d+%d] -> %d %s telah muncul! programmer semakin stres! \n", 
                    this.getBabyBugs(), this.spreadingBonus,(this.getBabyBugs() + this.spreadingBonus), this.getName());
            
        }else {
            attackMessages = attackMessages + String.format("%d %s telah muncul! programmer semakin stres! \n", this.getBabyBugs(), this.getName());
            
        }
        attackMessages = attackMessages + String.format("Kesehatan %s -%d", character.getName(), this.getAttackPower());
        
        return attackMessages;
    }
    
    @Override
    public String defend(){
        // jika monster defend maka next attack bonus +4, defend lagi maka bonus +8 dst
        String defMessages = ">> Giliran " + this.getName() + "\n";
        this.setSpreadingBonus(this.getSpreadingBonus() + 4);
        defMessages = defMessages + String.format("%s berhenti menyerang!", this.getName()) + "\n"
                + String.format("Bonus +%d untuk penyebaran %s selanjutnya!\n", this.getSpreadingBonus(), this.getName());
        
       
        return defMessages;
    }
}
