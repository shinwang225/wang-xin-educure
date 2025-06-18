public class Main4 {
    public static void main(String[] args) {
        int[][] seats = new int[5][6];
        // ここに座席予約のコードを書いてください
        seats[0][2] = 1;
        seats[1][1] = 1;
        seats[1][4] = 1;
        seats[3][0] = 1;
        seats[3][5] = 1;
        seats[4][2] = 1;

        int row = 2; 
        int column = 3;

        System.out.println("現在の座席状況：");
            for (int i = 0; i < seats.length; i++) {
                for (int l = 0; l < seats[i].length; l++) {
                System.out.print("[" + seats[i][l] + "]");
                }
            System.out.println();
            }

        if (row < 0 || row >= 5 || column < 0 || column >= 6) {
            System.out.println("無効な座席番号です。");
        } else if (seats[row][column] == 1) {
            System.out.println("指定された座席はすでに予約済みです。");
        } else {
            seats[row][column] = 1;
            System.out.println((row + 1) + "行" + (column+ 1) + "列の座席を予約しました");

            
        }
    }
}