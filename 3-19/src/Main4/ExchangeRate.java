package Main4;

public class ExchangeRate {
    // ドルレートとユーロレート（静的フィールド）
    private static double usdRate = 145.0;  // 初期のドルレート
    private static double eurRate = 160.0;  // 初期のユーロレート

    // レートを更新するメソッド（静的メソッド）
    public static void updateRates(double newUsdRate, double newEurRate) {
        usdRate = newUsdRate;
        eurRate = newEurRate;
        System.out.println("レート更新");
    }

    // 通貨を日本円に換算するメソッド（静的メソッド）
    public static int toJPY(String currency, double amount) {
        int result;

        if (currency.equals("USD")) {
            result = (int)(amount * usdRate);
            System.out.println((int)amount + "ドル = " + result + "円");// ドルから日本円に換算し、小数点以下を切り捨て
        } else if (currency.equals("EUR")) {
            result = (int)(amount * eurRate);
            System.out.println((int)amount + "ユーロ = " + result + "円"); // ユーロから日本円に換算し、小数点以下を切り捨て
        } else {
            result = -1;  // その他の通貨の場合 
        }
        return result;
    }
}
