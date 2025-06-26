import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Main4 {
    public static void processNumbers(int[] numbers) {
        // ここにコードを書いてください
        System.out.println("元のリスト: " + Arrays.toString(numbers));

        ArrayList<Integer> numList = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            numList.add(numbers[i]);
        }

        Collections.sort(numList);
        System.out.println("ソート後: " + numList);
        System.out.println("最大値: " + Collections.max(numList));
        System.out.println("最小値: " + Collections.min(numList));
    }
    public static void main(String[] args) {
        int[] numbers ={5,2,8,1,9};
        processNumbers(numbers);
    }
}
