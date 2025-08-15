package Main3;

public class Character implements Comparable <Character>{
    private String name;
    private int HP;
    private int attackPower;

    public Character(String name, int HP, int attackPower){
        this.name = name;
        this.HP = HP;
        this.attackPower = attackPower;
    }

    public int getBattlePower(){
        return  HP + attackPower;
    }

    @Override
    public int compareTo(Character other){
        return Integer.compare(other.getBattlePower(),this.getBattlePower());
    }

    @Override
    public String toString(){
        return name + "(HP:" + HP + " 攻撃力:" + attackPower + ") 戦闘力:" + getBattlePower();
    }
}
 