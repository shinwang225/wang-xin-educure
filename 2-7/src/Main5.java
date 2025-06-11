public class Main5 {
    public static void main(String[] args){
    int note = 280;
    int pencil = 120;
    int erase = 100;

    int subtotal = (note * 3) + (pencil * 5) +(erase * 2);
    double tax = subtotal * 0.1;
    int total = subtotal + (int)tax;

    int payAmount = 2000;
    int charge = payAmount - total;
    
    System.out.println("小計：" + subtotal + "円");
    System.out.println("消費税：" + (int)tax + "円");
    System.out.println("合計金額：" + total +"円");
    System.out.println("おつり：" + charge +  "円" );
    }
}
