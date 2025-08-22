package junit_4_18;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DividerTest {
    @Test
    void testNormalDivision() {
        Divider divider = new Divider();
        // 正の数の除算テスト
        assertEquals(3.0, divider.divide(6.0, 2.0), 0.0001, "6 ÷ 2 は 3 になるはず");
        
        // 負の数を含む除算テスト
        assertEquals(-4.0, divider.divide(-8.0, 2.0), 0.0001, "-8 ÷ 2 は -4 になるはず");

        // 小数を含む除算
        assertEquals(2.5, divider.divide(5.0, 2.0), 0.0001, "5 ÷ 2 は 2.5 になるはず");

        // 負の数同士の除算
        assertEquals(5.0, divider.divide(-10.0, -2.0), 0.0001, "-10 ÷ (-2)は 5 になるはず");
    }

    @Test
    void testExceptionDivision() {
        Divider divider = new Divider();
        // ゼロによる除算（正の数）
        assertThrows(IllegalArgumentException.class,
            () -> divider.divide(5.0, 0.0),
            "ゼロ除算で例外が発生するはず");

        // ゼロによる除算（負の数）
        assertThrows(IllegalArgumentException.class,
            () -> divider.divide(-3.0, 0.0),
            "ゼロ除算で例外が発生するはず");

        // ゼロをゼロで除算
        assertThrows(IllegalArgumentException.class,
            () -> divider.divide(0.0, 0.0),
            "ゼロ除算で例外が発生するはず");
    }

    @Test
    // 例外メッセージ確認
    void testExceptionMessage() {
        Divider divider = new Divider();

        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class,
                () -> divider.divide(100.0, 0.0),  
            "ゼロ除算で例外が発生するはず");

        assertEquals("ゼロで除算はできません", exception.getMessage());
    }

    @Test
    // 異なる値で例外メッセージ確認
    void testExceptionMessage_DifferentInputs() {
        Divider divider = new Divider();

        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class,
                () -> divider.divide(100.0, 0.0),  
            "ゼロ除算で例外が発生するはず");

        assertEquals("ゼロで除算はできません", exception.getMessage());
    }
}
