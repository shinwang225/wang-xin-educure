package Main4;

import java.util.ArrayList;
import java.util.List;

public class PartyMember implements Cloneable {
    private String name;         
    private List<String> skills; 

    public PartyMember(String name){
        this.name = name;
        this.skills = new ArrayList<>();
    }

    public void addSkill(String skill){
        skills.add(skill);
    }

    @Override
    public PartyMember clone(){
        try{
            PartyMember copy = (PartyMember)super.clone();
            copy.skills = new ArrayList<>(this.skills);
            return copy;
        }catch(CloneNotSupportedException e){
            throw new RuntimeException("コピーの作成に失敗しました",e);
        }
    }

    public void showSkills(){
        System.out.println(name + "のスキル: " + skills);
    }
}
