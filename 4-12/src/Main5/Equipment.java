package Main5;

import java.util.Objects;

public class Equipment implements Cloneable, Comparable<Equipment> {
    private String name;
    private int attack;
    private int defense;

    public Equipment(String name,int attack,int defense){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public int getPower(){
        return  attack + defense;
    }

    @Override
    public Equipment clone(){
        try{
            return(Equipment)super.clone();
        }catch(CloneNotSupportedException e){
            throw new RuntimeException("コピーの作成に失敗しました",e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Equipment)) return false;
        Equipment other = (Equipment) obj;
        return attack == other.attack
            && defense == other.defense
            && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attack, defense);
    }

    @Override
    public int compareTo(Equipment other){
        return Integer.compare(other.getPower(), this.getPower());
    }

    public String toString(){
        return name + " (攻撃力:" + attack + " 防御力:" + defense + ")";
    }





    
}
