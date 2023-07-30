import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private int count;

    private List<Ball> userBalls;

    public List<Ball> pickBall() {
        Scanner scanner = new Scanner(System.in);
        userBalls = new ArrayList<>();
        System.out.println("input number");
        while (true) {
            String next = scanner.next();
            if (count < 3 && validateUser(next)) {
                userBalls.add(new Ball(count, Integer.parseInt(next)));
            }
            if (count > 3) {
                break;
            }
            count++;
        }
        return userBalls;
    }

    private boolean validateUser(String next) {
        return BallUtill.isNotNumber(next) && BallUtill.rangeNumber(Integer.parseInt(next));
    }

}
