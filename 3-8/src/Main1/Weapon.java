package Main1;

public class Weapon {
    String name;
    int power;

    public Weapon(String name,int power){
        this.name = name;
        this.power = power;
    }

    public String getName(){
        return name;
    }

    public int getPower(){
        return power;
    }
}
