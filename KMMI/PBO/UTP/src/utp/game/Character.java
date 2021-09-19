package utp.game;

public class Character {
    private String name = "Character";
    private int health = 100;
    private int attackPower = 10;

    public Character(){
        
    }
    public Character(String name){
        this.name = name;
    }
    public Character(String name, int attackPower, int health) {
        this.name = name;
        this.attackPower = attackPower;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        // logic biar health : 0 - 100
        if(health >= 100) {
            this.health = 100;
        } else if (health >= 0) {
            this.health = health;
        } else {
            this.health = 0;
        }
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        // logic biar power gk minus
        if (attackPower >=0) this.attackPower = attackPower;
        else this.attackPower = attackPower;
    }

    // tipe string karena akan dimasukkan ke JOptionPane
    
    public String attack(Character character){
        String messages = String.format("%s menyerang %s! -> %d dmg", this.name, character.name, this.attackPower);
        messages += String.format("\n Darah %s -%d", character.name, this.attackPower);
        
        // pengurangan darah musuh
        character.setHealth(character.getHealth() - this.attackPower);
        
        messages += String.format("Darah %s : %d \n", character.name, character.getHealth());
        return messages;
    }
    
    
    public String defend(){
        
        this.health += 5;
        String messages = this.name + " bertahan!";
        System.out.println(String.format("%s darah (+5) -> %d", this.name, this.health));
        return messages;
    }
    
    public void printAttributes(){
        System.out.println("Atribut Character:");
        System.out.println("Nama : " + this.name);
        System.out.println("AttackPower : " + this.attackPower);
        System.out.println("Health : " + this.health);
        System.out.println();
    }
    
    public String cetakAttributes(){
        String x = "Atribut Character"
                + "\nNama : " + this.name
                + "\nAttackPower : " + this.attackPower
                + "\nHealth : " + this.health
                + "\n";
        return x;
    }
    
    
}
