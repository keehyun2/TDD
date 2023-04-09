package ch02;

public class PasswordValidator {

    /**
     * - 길이 8글자 이상
     * - 0부터 9사이 숫자를 초함
     * - 대문자 포함
     * 3개 규칙을 충족하면 암호는 강함
     * 2개 규칙을 충족하면 암호는 보통
     * 0~1 이하의 규칙을 충족하면 암호는 약함이다.
     * @param password 패스워드
     * @return 패스워드 강도
     */
    public Strength pwStrength(String password){
        return Strength.WEAK;
    }

    public enum Strength {
        WEAK,
        NORMAL,
        STRONG
    }
}
