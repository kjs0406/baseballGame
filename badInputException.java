package exam.step1;

public class badInputException extends Exception {
    public badInputException(String type) {
        super("잘못된 입력입니다! " + type + "을 입력해주세요!");
    }
}