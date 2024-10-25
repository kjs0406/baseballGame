package exam.step1;

public class Count {
    private static int countStrike;
    protected static int validateInput;
    private static int countBall;

    public Count(int validateInput, int countStrike, int countBall) {
        this.validateInput = validateInput;
        this.countStrike = countStrike;
        this.countBall = countBall;
    }
    public static int getCountStrike() {
        return countStrike;
    }
    public static int getCountBall() {
        return countBall;
    }
    public static int isValidateInput() {
        return validateInput;
    }
    public static void setValidateInput(int oCount) {
        validateInput = oCount;
    }
    public static void setCountStrike(int sCount) {
        countStrike = sCount;
    }
    public static void setCountBall(int bCount) {
        countBall = bCount;
    }
}
