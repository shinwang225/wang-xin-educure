import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) {
        int[] prices = {100,200,300};  // 商品価格
        int[] quantities = {1,2,3};    // 数量

        if (prices.length != quantities.length) {
            System.out.println("IllegalArgumentException: 価格と数量の配列の長さが一致しません");
        } else {
            int[] totals = calculateTotals(prices, quantities);
            System.out.println("商品価格: " + Arrays.toString(prices) + ", 数量: " + Arrays.toString(quantities));
            System.out.println("合計金額: " + Arrays.toString(totals));
        }
    }

    public static int[] calculateTotals(int[] prices, int[] quantities){
        int[] totals = new int[prices.length];
        for(int i = 0; i < prices.length ; i++){
            double total = prices[i] * quantities[i] * 1.08;
            totals[i] = (int)(total + 0.5);
        }
        return totals;
    }
}