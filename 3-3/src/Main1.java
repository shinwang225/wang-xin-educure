public class Main1 {
    public static void main(String[] args) {
    
        Pet a = new Pet();
        a.setName("ポチ");
        a.setEnergy(100);

        System.out.println(a.getName() + "を生み出しました!");
        System.out.println("初期体力：" + a.getEnergy());

        
        a.eat();
        a.showEnergy();
        a.play();
        a.showEnergy();
    }
}