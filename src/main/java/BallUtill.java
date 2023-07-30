import java.util.ArrayList;
import java.util.Random;

public class BallUtill {


    public static Balls createRandomBall(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Ball> balls = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            setRandomBalls(list, balls, i);
        }

        return new Balls(balls);
    }

    private static void setRandomBalls(ArrayList<Integer> list, ArrayList<Ball> balls, int index) {
        while (true){
            int randomNum = randomNumber();
            if (!list.contains(randomNum)) {
                list.add(randomNum);
                balls.add(new Ball(index, randomNum));
                break;
            }
        }
    }

    private static int randomNumber() {
        Random random = new Random();
        int randomNumber =0;
        while (!rangeNumber(randomNumber)) {
            randomNumber = random.nextInt(10) + 1;
        }
        return randomNumber;
    }

    public static boolean rangeNumber(int randomNumber) {
        return randomNumber > 0 && randomNumber < 9;
    }


    public static boolean isNotNumber(String next) {
        try {
            Integer.parseInt(next);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
