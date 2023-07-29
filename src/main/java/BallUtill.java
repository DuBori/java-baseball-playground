import java.util.ArrayList;
import java.util.Random;

public class BallUtill {


    public static Balls createRandomBall(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Ball> balls = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (!list.contains(randomNumber())) {
                Ball randomBall = new Ball(i, randomNumber());
                balls.add(new Ball(i, randomBall.getNumber()));
            }
        }

        return new Balls(balls);
    }

    private static int randomNumber() {
        Random random = new Random();
        int randomNumber =0;
        while (!rangeNumber(randomNumber)) {
            randomNumber = random.nextInt(10) + 1;
        }
        return randomNumber;
    }

    private static boolean rangeNumber(int randomNumber) {
        return randomNumber > 0 && randomNumber < 9;
    }
}
