public class Main1 {
    public static void processString(String input) {
        // ここにコードを書いてください
        
        String output = input.toUpperCase();
        System.out.println("出力: \"" + output + "\"");
        System.out.println("文字数: " + input.length());
    }
    public static void main(String[] args) {
        String input = "Hello World";
        System.out.println("入力: \"" + input + "\"");
        processString(input);
    }
}