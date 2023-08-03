import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    static Scanner scanner = new Scanner(System.in);
    static int count =0;

    public static void main(String[] args) {
        BallResult ballResult = new BallResult();
        Balls randomBall = BallUtill.createRandomBall(3);
        boolean playGame = true;
        while (playGame) {
            String[] split = playForJustMent();
            Balls userBall = new Balls(settingUserBalls(split));

            if (count > 2) {
                ballResult = randomBall.matchBalls((ArrayList<Ball>) userBall.getList());
            }
            if (ballResult.getResult() == 3) {
                playGame = checkUserMind();
            }
            init(userBall);
        }
    }

    private static String[] playForJustMent() {
        System.out.println("숫자를 입력해 주세요.");
        String next = scanner.next();
        String[] split = next.split("");
        return split;
    }

    private static void init(Balls userBall) {
        userBall.clearList();
        count = 0;
    }

    private static boolean checkUserMind() {
        String userInput;
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            userInput = scanner.next();
            if(!playMoreGame(userInput)) {
                break;
            }
        }
        return false;
    }

    private static ArrayList<Ball> settingUserBalls(String[] split) {
        ArrayList<Ball> balls = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (BallUtill.isNotNumber(split[i]) && BallUtill.rangeNumber(Integer.parseInt(split[i]),null)) {
                balls.add(new Ball(count,Integer.parseInt(split[i])));
                count++;
            }
        }
        return balls;
    }

    private static boolean playMoreGame(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            System.out.println("1 또는 2를 입력");
            return false;
        }
        if(userInput.equals("1")){
            return true;
        }
        return false;
    }

    @Test
    void printToUser() {
        User user = new User();
        Balls balls = user.getBalls();
        Balls userBalls = new Balls();
        userBalls.getList()
                .forEach(it -> System.out.println(it.getNumber()));
    }


    @Test
    @Disabled
    void matchBallByInputAndReturnResult() {
        ArrayList<Ball> inputBall = new ArrayList<>();
        inputBall.add(new Ball(0,1));
        inputBall.add(new Ball(1,2));
        inputBall.add(new Ball(2,3));
        Balls Balls = BallUtill.createRandomBall(3);

        System.out.print("randomNumber is ");
        Balls.getList().forEach(it-> System.out.print(it.getNumber()));
        System.out.println();
        System.out.print("=============");
        boolean isNotResult = true;
        do{
            BallResult result = Balls.matchBalls(inputBall);
            result.getResult();
            if (result.getStrike() == 3) {
                isNotResult =false;
            }
        }while(isNotResult);
    }


}