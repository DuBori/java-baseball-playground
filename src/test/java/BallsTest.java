import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    @Test
    void printToUser() {
        User user = new User();
        List<Ball> balls = user.pickBall();
        Balls userBalls = new Balls(balls);
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