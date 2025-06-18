public class Main1 {
    public static void main(String[] args) {
        // ここに配列を作成し、点数を代入するコードを書いてください
        int[]score = {85,90,75,95,80};
        
        // ここに点数を表示するコードを書いてください
        for(int i = 0 ; i < score.length ; i++){
            System.out.println((i+1) + "番目の生徒：" + score[i] + "点");
        }
    }   
}