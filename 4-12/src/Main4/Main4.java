package Main4;

public class Main4 {
    public static void main(String[] args) {
        PartyMember pm1 = new PartyMember("アリス");
        pm1.addSkill("ファイア");
        pm1.addSkill("ブリザード");

        PartyMember pm2 = pm1.clone();
        pm2.addSkill("サンダー");

        System.out.println("--- 深いコピー後にスキル追加 ---");
        pm1.showSkills("元のキャラクター");
        pm2.showSkills("コピーしたキャラクター");

    }
}
