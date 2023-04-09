package ch02;

public class PasswordValidator {

    /**
     * 
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
