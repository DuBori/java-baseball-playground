import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    @Test
    void Balls() {
        ArrayList<Ball> inputBall = new ArrayList<>();
        inputBall.add(new Ball(0,1));
        inputBall.add(new Ball(1,2));
        inputBall.add(new Ball(2,3));
        Balls Balls = BallUtill.createRandomBall(3);
    }


}