package exam.step1;



public class Main {
    public static void main(String[] args) {


        BaseballGame baseballGame = new BaseballGame();
        try {
          baseballGame.play();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

