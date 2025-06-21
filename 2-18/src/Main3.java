public class Main3 {
    public static void main(String[] args) {
        String input = "Hello";  // 逆順にする文字列

        String output = reverseString(input);
        System.out.println(output);
    }

    public static String reverseString(String input){
       return new StringBuilder(input).reverse().toString();
    }
}