import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    static Scanner scanner = new Scanner(System.in);
    static int count =0;
    public static void main(String[] args) {
        List<Ball> balls = new ArrayList<>();
        while (count < 3) {
            String next = scanner.next();
            if (BallUtill.isNotNumber(next) && BallUtill.rangeNumber(Integer.parseInt(next))) {
                balls.add(new Ball(count,Integer.parseInt(next)));
                count++;
            }
        }
        Balls randomBall = BallUtill.createRandomBall(3);
        BallResult ballResult = randomBall.matchBalls((ArrayList<Ball>) balls);
        ballResult.getResult();
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