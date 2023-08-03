import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> list;

    public List<Ball> getList() {
        return list;
    }

    public Balls() {
    }

    public Balls(List<Ball> balls) {
        this.list = balls;
    }


    public BallResult matchBalls(ArrayList<Ball> inputBall) {
        List<BallState> states = new ArrayList<>();
        for (int i=0; i < list.size(); i++) {
            Ball ball = list.get(i);
            states.add(ball.Play(inputBall));
        }
        return new BallResult(states);
    }
}
