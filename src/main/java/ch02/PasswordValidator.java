package ch02;

public class PasswordValidator {

    /**
     * - 길이 8글자 이상
     * - 0부터 9사이 숫자를 포함
     * - 대문자 포함
     * 3개 규칙을 충족하면 암호는 강함
     * 2개 규칙을 충족하면 암호는 보통
     * 0~1 이하의 규칙을 충족하면 암호는 약함이다.
     * @param password 패스워드
     * @return 패스워드 강도
     */
    public Strength checkStrength(String password){
        if(password == null) return Strength.WEAK;
        int passCount = 0;
        if(password.length() > 7) {
            passCount += 1;
        }
        // 소문자로 바꿧을때 동일하면 대문자가 없음
        if(!password.equals(password.toLowerCase())){
            passCount += 1;
        }
        if(isContainNum(password)){
            passCount += 1;
        }
        return switch (passCount) {
            case 0, 1 -> Strength.WEAK;
            case 2 -> Strength.NORMAL;
            case 3 -> Strength.STRONG;
            default -> null;
        };
    }

    private boolean isContainNum(String password){
        for(char c : password.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

}
