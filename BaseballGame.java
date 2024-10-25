package exam.step1;

import java.util.*;
import java.util.regex.Pattern;

public class BaseballGame {
    // HashSet을 이용하여 숫자를 중복 없이 저장
    HashSet<Integer> randomNumber = new HashSet<>();
    List<Integer> randomNumberSet = new ArrayList<>();
    // 숫자만 입력 가능하도록
  private static final String numberReg = "^[0-9]*$";

  public BaseballGame() {
      // random 클래스
      Random ranNumber = new Random();
      while(randomNumber.size() < 3) {
          randomNumber.add(ranNumber.nextInt(9));
          }
      // hashset의 값을 list에 저장
      Iterator iter = randomNumber.iterator();
      while(iter.hasNext()) {
        randomNumberSet.add(Integer.valueOf(iter.next().toString()));
      }
  }
  public void play() throws Exception {
      while(true) {
          int sCount = 0;
          int bCount = 0;
          int oCount = 3;
          List<Integer> inputNumberSet = new ArrayList<>();
          Scanner sc = new Scanner(System.in);
          System.out.println("첫번째 숫자를 입력하세요.");

          String firstNum = sc.next();
          // 숫자가 아닌 입력 값
          if (!Pattern.matches(numberReg, firstNum)) {
              throw new badInputException("숫자");
              // 2자리 이상의 값
          } else if (firstNum.length() > 1) {
              System.out.println("한자리 수만 입력 가능합니다.");
              break;
          }
          // 값을 int형으로 변환하여 저장
          inputNumberSet.add(Integer.valueOf(firstNum));

          System.out.println("두번째 숫자를 입력하세요.");
          String secondNum = sc.next();
          // 첫번째와 두번째의 값이 같을 경우
          if (Objects.equals(firstNum, secondNum)) {
              System.out.println("중복된 숫자는 입력할 수 없습니다.");
              break;
          } else if (secondNum.length() > 1) {
              System.out.println("한자리 수만 입력 가능합니다.");
              break;
          } else if (!Pattern.matches(numberReg, secondNum)) {
              throw new badInputException("숫자");
          }
          inputNumberSet.add(Integer.valueOf(secondNum));

          System.out.println("세번째 숫자를 입력하세요.");
          String thirdNum = sc.next();
          if (Objects.equals(firstNum, thirdNum) || Objects.equals(secondNum, thirdNum)) {
              System.out.println("중복된 숫자는 입력할 수 없습니다.");
              break;
          } else if (thirdNum.length() > 1) {
              System.out.println("한자리 수만 입력 가능합니다.");
              break;
          } else if (!Pattern.matches(numberReg, secondNum)) {
              throw new badInputException("숫자");
          }
          inputNumberSet.add(Integer.valueOf(thirdNum));
          // 값을 비교하여 strike 인지 ball 인지 판단
          for(int i=0;i<inputNumberSet.size();i++) {
              if(inputNumberSet.get(i).equals(randomNumberSet.get(i))) {
                sCount++;
              }
          }
          if(sCount == inputNumberSet.size()) {
              System.out.println("축하합니다 모든 숫자를 맞추었습니다.");
              break;
          }
          Count.setCountStrike(sCount);
          for(int i= 0; i < randomNumberSet.size(); i++) {
              for(int j = 0; j < inputNumberSet.size(); j++) {
                  if(i != j && randomNumberSet.get(i).equals(inputNumberSet.get(j))) {
                      bCount++;
                  }
              }
          }

          oCount = oCount - bCount - sCount;
          Count.setCountBall(bCount);
          Count.setValidateInput(oCount);

          System.out.println("스트라이크 카운트 : "+ Count.getCountStrike());
          System.out.println("볼카운트 : "+ Count.getCountBall());
          System.out.println("아웃 : "+ Count.isValidateInput());
          }
  }
}
