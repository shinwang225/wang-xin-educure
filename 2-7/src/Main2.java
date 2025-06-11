public class Main2 {
    public static void main(String[] args){
        int price = 2500;
        double discountRate= 0.2;
        int discountAmount = (int)(price * discountRate);

        System.out.println("割引額：" + discountAmount +"円");
        System.out.println("販売価格：" + (price - discountAmount) + "円");
    }
}
