import java.util.ArrayList;
import java.util.Random;

public class BallUtill {


    public static final Random RANDOM = new Random();
    public static final String COMPUTER = "com";

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
                System.out.println("randomNum = " + randomNum);
                list.add(randomNum);
                balls.add(new Ball(index, randomNum));
                break;
            }
        }
    }

    private static int randomNumber() {
        int randomNumber =0;
        while (!rangeNumber(randomNumber, COMPUTER)) {
            randomNumber = RANDOM.nextInt(10) + 1;
        }

        return randomNumber;
    }

    public static boolean rangeNumber(int randomNumber,String COMPUTER) {
        if (randomNumber > 0 && randomNumber < 9) {
            return true;
        }
        if (COMPUTER != null && "".equals(COMPUTER)) {
            System.out.println("plz range input number 1 to 9");
        }

        return false;
    }


    public static boolean isNotNumber(String next) {
        try {
            Integer.parseInt(next);
        } catch (Exception e) {
            System.out.println("plz input number");
            return false;
        }
        return true;
    }
}
