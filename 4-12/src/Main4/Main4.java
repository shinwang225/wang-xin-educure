package Main4;

public class Main4 {
    public static void main(String[] args) {
        PartyMember pm1 = new PartyMember("元のキャラクター「アリス」");
        pm1.addSkill("ファイア");
        pm1.addSkill("ブリザード");

        PartyMember pm2 = pm1.clone();
        pm2.addSkill("サンダー");

        System.out.println("--- 深いコピー後にスキル追加 ---");
        pm1.showSkills();
        pm2.showSkills();

    }
}
