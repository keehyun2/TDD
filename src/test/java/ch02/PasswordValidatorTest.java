package ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    @DisplayName("패스워드 강도 체크")
    void test(){
        PasswordValidator passwordValidator = new PasswordValidator();


        assertEquals(passwordValidator.pwStrength(""), PasswordValidator.Strength.WEAK);

    }
}