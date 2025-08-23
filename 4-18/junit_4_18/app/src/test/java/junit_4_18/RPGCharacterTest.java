package junit_4_18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class RPGCharacterTest {
    @Test
    void testInitialStatus() {
        // 初期状態のテスト
        RPGCharacter character = new RPGCharacter();
        assertEquals(1,   character.getLevel(), "初期レベルは1であるはず");
        assertEquals(100, character.getHP(),    "初期HPは100であるはず");
        assertEquals(50,  character.getMP(),    "初期MPは50であるはず");
    }

    @Test
    void testNormalLevelUp() {
        // 通常のレベルアップテスト
        RPGCharacter character = new RPGCharacter();
        character.levelUp();
        assertEquals(2,   character.getLevel(), "レベルが2になるはず");
        assertEquals(110, character.getHP(),    "HPが110になるはず");
        assertEquals(55,  character.getMP(),    "MPが55になるはず");
    }

    @Test
    void testMaxLevel() {
        // 境界値のテスト
        RPGCharacter character = new RPGCharacter();

        // レベル98まで上ける
        for (int i = 0; i < 97; i++) character.levelUp();

        // 98 → 99
        character.levelUp();
        assertEquals(99,  character.getLevel(), "レベルが99になるはず");
        assertEquals(1080, character.getHP(),   "HPが1080になるはず"); 
        assertEquals(540,  character.getMP(),   "MPが540になるはず");

        // レベル99からのレベルアップ
        IllegalStateException exception = assertThrows(
            IllegalStateException.class,() -> character.levelUp(), 
                "最大レベルで例外が発生するはず");

        // 例外メッセージの確認
        assertEquals("最大レベルに達しています", exception.getMessage(),
            "例外メッセージが正しいはず");
    }
}
