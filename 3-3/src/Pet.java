public class Pet{
    String name;
    int energy;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setEnergy(int energy){
        this.energy = energy;
    }

    public int getEnergy(){
        return this.energy;
    }

    public void eat(){
        this.energy += 10;
        System.out.println(this.name + "は食事をして元気になった！");
    }

    public void play(){
        this.energy -= 20;
        System.out.println(this.name + "は遊んで疲れた！");
    }
    
    public void showEnergy() {
        System.out.println("現在の体力：" + this.energy);
    }

}
