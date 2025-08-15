package Main2;

import java.util.Objects;

public class Monster {
    private final String name;
    private final int level;

    public Monster(String name, int level){
        this.name = name;
        this.level = level;
    }

    public String getName() { return name; }
    public int getLevel() { return level; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                     // 同一参照
        if (obj == null || getClass() != obj.getClass())  // null/型チェック
            return false;
        Monster other = (Monster) obj;
        return level == other.level &&
            Objects.equals(name, other.name);
    }  
   
    @Override
    public int hashCode(){
        return Objects.hash(name,level);
    }

    @Override
    public String toString(){
        return name + "Lv." + level;
    }

}