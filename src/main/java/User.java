import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private Scanner scanner;

    private int count;

    private List<Ball> userBalls;

    public User() {
        scanner = new Scanner(System.in);
    }

    public List<Ball> pickBall() {
        userBalls = new ArrayList<>();
        while (count < 3) {
            String next = scanner.next();
            if (validateUserBall(next)) {
                userBalls.add(new Ball(count, Integer.parseInt(next)));
                count++;
            }
        }
        scanner.close();
        return userBalls;
    }

    private boolean validateUserBall(String next) {
        return BallUtill.isNotNumber(next) && BallUtill.rangeNumber(Integer.parseInt(next));
    }

}
