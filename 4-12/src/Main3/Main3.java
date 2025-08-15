package Main3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        
        List<Character> list = new ArrayList<>();
        list.add(new Character("勇者A", 100, 50));  
        list.add(new Character("魔法使いB", 70, 70));
        list.add(new Character("戦士C", 80, 40));

        Collections.sort(list);

        System.out.println("--- 戦闘力順 ---");
        for (Character c : list) {
            System.out.println(c);
        }
    }
}
