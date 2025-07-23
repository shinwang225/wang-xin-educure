package Main4;

public class Main4 {
    public static void main(String[] args) {
        
        // 初期レートで100ドル換算
        ExchangeRate.toJPY("USD", 100);

        // レート更新
        ExchangeRate.updateRates(150.0, 160.0);

        // 更新後のレートで換算
        ExchangeRate.toJPY("USD", 100);
        ExchangeRate.toJPY("EUR", 80);

    }
}  
