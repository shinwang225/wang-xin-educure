public class Main7 {
    public static void main(String[] args) {
        int key = 3;        // 押したキーの番号
        int pressCount = 1; // 押下回数
        
        switch (key) {
            case 1:
                switch (pressCount) {
                    case 1:
                        System.out.println("A");
                        break;
                    case 2:
                        System.out.println("B");
                        break;
                    default:
                        System.out.println("C");
                        break;
                }
                break;
            case 2:
                switch (pressCount) {
                    case 1:
                        System.out.println("D");
                        break;
                    case 2:
                        System.out.println("E");
                        break;
                    default:
                        System.out.println("F");
                        break;
                }
                break;

            default:
                System.out.println("Invalid key");
                break;
        }
    }
}