import java.util.List;

public class Balls {

    private List<Ball> list;

    public Balls() {
    }

    public Balls(List<Ball> balls) {
        this.list = checkDuplicate(balls);
    }

    private List<Ball> checkDuplicate(List<Ball> balls) {
        return balls;
    }

    public void isContains(Ball randomBall) {

    }
}
