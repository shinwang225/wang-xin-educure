package Main1;

public class Sword extends Weapon {

    public String getName(){
        return this.name;
    }
    public int getPower(){
        return this.power;
    }

    public Sword(String name,int power){
        super.name = name;
        super.power = power;
    }
}
