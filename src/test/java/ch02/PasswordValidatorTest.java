package ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    @DisplayName("패스워드 강도 체크")
    void test(){
        PasswordValidator pv = new PasswordValidator();

        // 빈문자열 weak
        assertEquals(pv.checkStrength(""), Strength.WEAK);

        // 숫자만 포함, weak
        assertEquals(pv.checkStrength("1"), Strength.WEAK);

        // 길이만 8글자 weak
        assertEquals(pv.checkStrength("asdfdgvv"), Strength.WEAK);
        // 8글자, 숫자포함 normal
        assertEquals(pv.checkStrength("asdfdg4v"), Strength.NORMAL);

        // 대문자 포함 weak
        assertEquals(pv.checkStrength("A"), Strength.WEAK);

        // 1234567A  - 8글자, 숫자, 대문자포함 strong
        assertEquals(pv.checkStrength("1234567A"), Strength.STRONG);

    }
}