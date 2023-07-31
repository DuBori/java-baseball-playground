import java.util.List;
import java.util.Scanner;

public class User {
    private Scanner scanner;

    private Balls userBalls;

    public Balls getBalls() {
        return this.userBalls;
    }
    public User() {

    }
    public User(List<Ball> balls) {
        userBalls = new Balls(balls);
    }
}
