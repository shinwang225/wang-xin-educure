package Main5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameCharacter {
    private String name;         
    private List<Equipment> equipments; 

    public GameCharacter(String name){
        this.name = name;
        this.equipments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEquipment(Equipment eq) {
        equipments.add(eq);
    }

    public void showEquipments(){
        for (int i = 0; i < equipments.size(); i++) {
            System.out.println((i + 1) + ". " + equipments.get(i));
        }
    }

    public void sortEquipments() {
        Collections.sort(equipments); 
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }
}

