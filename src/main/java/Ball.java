import java.util.ArrayList;
import java.util.List;

public class Ball {

    public static final int MAX_NUMBER = 9;
    public static final int MIN_NUMBER = 1;
    private int index;
    private int  number;
    private int count;

    public int getNumber() {
        return number;
    }

    public Ball(int index, int number) {
        this.index = index;
        this.number = initNumber(number);
    }

    private int initNumber(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER){
            new IllegalAccessError("input number 1 to 9 plz");
        }
        return number;
    }

    public BallState Play(ArrayList<Ball> inputBall) {

        if (this.equals(inputBall)) {
            return BallState.STRIKE;
        }

        if (isBall(inputBall)) {
            return BallState.BALL;
        }
        return BallState.NOTHING;
    }

    private boolean isBall(ArrayList<Ball> inputBall) {
        return inputBall.stream()
                .anyMatch(it -> this.number == it.number);
    }

    @Override
    public boolean equals(Object obj) {
        ArrayList<Ball> balls = (ArrayList<Ball>) obj;
        return balls.stream()
                .anyMatch(it -> this.index == it.index && this.number == it.number);
    }
}
