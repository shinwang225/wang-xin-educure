public class Main3 {
    public static boolean validateUsername(String username) {
        if (username.matches("^[A-Za-z0-9_]{4,16}$")) {
            if (!username.matches("^[0-9]+$")) {
            return true; 
            }
        }
        return false; 
    }

    public static boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // テストケース
        String[] usernames = {"Player_1", "123456", "P@layer"};
        String[] passwords = {"Password123", "password123", "Pass"};
        
        System.out.println("ユーザー名チェック:");
            for(String username : usernames){
                if(validateUsername(username)){
                    System.out.println(username +": 有効");
                }else{
                    System.out.println(username + "：無効");
                }
            }
        
        System.out.println("パスワードチェック:");
            for(String password : passwords){
                if (validatePassword(password)) {
                    System.out.println(password +": 有効");
                }else{
                    System.out.println(password+ "：無効");
                }
            }
    }
}